package org.haedal.zzansuni.auth.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.haedal.zzansuni.global.jwt.JwtToken;
import org.haedal.zzansuni.global.jwt.JwtUser;
import org.haedal.zzansuni.global.jwt.JwtUtils;
import org.haedal.zzansuni.user.domain.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.util.Pair;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthService {
    private final List<OAuth2Client> oAuth2Clients;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final UserReader userReader;
    private final UserStore userStore;
    private final RefreshTokenStore refreshTokenStore;
    private final RefreshTokenReader refreshTokenReader;

    /**
     * OAuth2 로그인 또는 회원가입 <br> [state]는 nullable한 입력 값이다.<br> 1. OAuth2Client를 이용해 해당 provider로부터
     * 유저정보를 가져옴 2. authToken으로 유저를 찾거나 없으면 회원가입 3. 토큰 발급, 유저정보 반환
     */
    public Pair<JwtToken, UserModel.Main> oAuth2LoginOrSignup(OAuth2Provider provider,
                                                              @NonNull String code, @Nullable String state) {
        OAuth2Client oAuth2Client = oAuth2Clients.stream()
            .filter(client -> client.canHandle(provider))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 OAuth2Provider 입니다."));

        // OAuth2Client를 이용해 해당 provider로부터 유저정보를 가져옴
        OAuthUserInfoModel oAuthUserInfoModel = oAuth2Client.getAuthToken(code, state);

        // authToken으로 유저를 찾아서 없으면 [OAuthUserInfoModel]를 통해서 회원가입 진행
        User user = userReader
            .findByAuthToken(oAuthUserInfoModel.authToken())
            .orElseGet(() -> signup(oAuthUserInfoModel, provider));

        // 토큰 발급, 유저정보 반환
        JwtToken jwtToken = createToken(user);
        UserModel.Main userMain = UserModel.Main.from(user);
        return Pair.of(jwtToken, userMain);
    }


    private User signup(OAuthUserInfoModel oAuthUserInfoModel, OAuth2Provider provider) {
        UserCommand.CreateOAuth2 command = oAuthUserInfoModel.toCreateCommand(provider);
        User user = User.create(command);
        return userStore.store(user);
    }

    /**
     * JWT 발급
     * 1. 리프래시토큰의 uuid 생성
     * 2. JWT 토큰 생성
     * 3. DB에 리프래시토큰 정보를 저장, 리프래시토큰의 UUID가 PK이므로 중복이 발생하면 재시도 10회
     */
    private JwtToken createToken(User user) {
        JwtUser jwtUser = JwtUser.of(user.getId(), user.getRole());
        //Retry 10 times
        for (int i = 0; i < 10; i++) {
            try {
                String uuid = UUID.randomUUID().toString();

                JwtToken jwtToken = jwtUtils.generateToken(jwtUser, uuid);
                RefreshToken refreshToken = RefreshToken.create(uuid, user, jwtToken.getRefreshTokenExpireAt());
                // Inner TX Scope
                refreshTokenStore.store(refreshToken);
                return jwtToken;
            } catch (DataIntegrityViolationException e) {
                log.debug("RefreshToken UUID 충돌. Retry: {}", i);
            }
        }
        throw new RuntimeException("Failed to create token.");
    }

    @Transactional
    public Pair<JwtToken, UserModel.Main> signup(UserCommand.Create command) {
        if (userReader.existsByEmail(command.getEmail())) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }
        command = command.copyEncodedPassword(passwordEncoder.encode(command.getPassword()));
        User user = User.create(command);
        userStore.store(user);
        JwtToken jwtToken = createToken(user);
        UserModel.Main userMain = UserModel.Main.from(user);
        return Pair.of(jwtToken, userMain);
    }

    @Transactional
    public void createManager(UserCommand.Create command) {
        if (userReader.existsByEmail(command.getEmail())) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }
        command = command.copyEncodedPassword(passwordEncoder.encode(command.getPassword()));
        User user = User.createManager(command);
        userStore.store(user);
    }

    @Transactional
    public Pair<JwtToken, UserModel.Main> login(String email, String password) {
        User user = userReader.findByEmail(email)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 이메일입니다."));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        JwtToken jwtToken = createToken(user);
        UserModel.Main userMain = UserModel.Main.from(user);
        return Pair.of(jwtToken, userMain);
    }

    @Transactional
    public JwtToken reissueToken(String rawToken) {
        JwtUtils.UserIdAndUuid userIdAndUuid = jwtUtils.validateAndGetUserIdAndUuid(rawToken);

        RefreshToken refreshToken = refreshTokenReader.findById(userIdAndUuid.uuid())
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 토큰입니다."));

        // jwtUtils에서 이미 검증하였으나, 방어적으로 다시 한번 검증
        if(!refreshToken.getUser().getId().equals(userIdAndUuid.userId())) {
            throw new IllegalArgumentException("토큰의 유저정보가 일치하지 않습니다.");
        }else if(refreshToken.getExpiredAt().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("만료된 토큰입니다.");
        }

        refreshTokenStore.delete(refreshToken.getId());
        User user = refreshToken.getUser();
        return createToken(user);
    }
}