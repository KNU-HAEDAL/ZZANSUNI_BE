package org.haedal.zzansuni.controller.auth;

import lombok.Builder;
import org.haedal.zzansuni.controller.user.UserRes;
import org.haedal.zzansuni.domain.user.UserModel;
import org.haedal.zzansuni.global.jwt.JwtToken;

public class AuthRes {
    @Builder
    public record LoginResponse(
            String accessToken,
            String refreshToken,
            UserRes.UserInfo userInfo
    ) {
        public static LoginResponse from(JwtToken jwtToken, UserModel.Main userMain) {
            var userInfo = UserRes.UserInfo.from(userMain);
            return LoginResponse.builder()
                    .accessToken(jwtToken.getAccessToken())
                    .refreshToken(jwtToken.getRefreshToken())
                    .userInfo(userInfo)
                    .build();
        }
    }

    @Builder
    public record AccessTokenResponse(
            String accessToken
    ) {
        public static AccessTokenResponse of(String accessToken) {
            return AccessTokenResponse.builder()
                    .accessToken(accessToken)
                    .build();
        }
    }
}
