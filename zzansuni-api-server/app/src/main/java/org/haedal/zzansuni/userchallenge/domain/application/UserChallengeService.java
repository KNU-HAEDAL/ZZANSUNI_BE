package org.haedal.zzansuni.userchallenge.domain.application;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.haedal.zzansuni.challengereview.domain.ChallengeReviewReader;
import org.haedal.zzansuni.userchallenge.domain.port.UserChallengeReader;
import org.haedal.zzansuni.userchallenge.domain.port.UserChallengeStore;
import org.haedal.zzansuni.userchallenge.domain.port.ChallengeGroupUserExpStore;
import org.haedal.zzansuni.challengegroup.domain.Challenge;
import org.haedal.zzansuni.challengegroup.domain.ChallengeCommand;
import org.haedal.zzansuni.challengegroup.domain.application.ChallengeModel;
import org.haedal.zzansuni.challengegroup.domain.port.ChallengeReader;
import org.haedal.zzansuni.user.domain.User;
import org.haedal.zzansuni.user.domain.port.UserReader;
import org.haedal.zzansuni.userchallenge.domain.ChallengeGroupUserExp;
import org.haedal.zzansuni.userchallenge.domain.UserChallenge;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserChallengeService {

    private final UserChallengeStore userChallengeStore;
    private final UserChallengeReader userChallengeReader;
    private final ChallengeReviewReader challengeReviewReader;
    private final UserReader userReader;
    private final ChallengeReader challengeReader;
    private final ChallengeGroupUserExpStore challengeGroupUserExpStore;
    private final AddUserExpByVerificationUseCase addUserExpByVerificationUseCase;
    /**
     * 챌린지 참여하기 <br>
     * 1. 유저와 챌린지 정보를 받아서 UserChallenge 테이블에 데이터 추가
     * 2. 챌린지그룹-유저 경험치 테이블에 데이터 추가
     */
    @Transactional
    public void participateChallenge(Long userId, Long challengeId) {
        User user = userReader.getById(userId);
        Challenge challenge = challengeReader.getById(challengeId);

        //이미 참여한 챌린지인지 확인
        userChallengeReader.findByUserIdAndChallengeId(userId, challengeId)
            .ifPresent(userChallenge -> {
                throw new IllegalArgumentException("이미 참여한 챌린지입니다.");
            });
        LocalDate now = LocalDate.now();
        LocalDate deadline = now.plusDays(challenge.getActivePeriod());
        UserChallenge userChallenge = UserChallenge.create(challenge, user, now, deadline);
        userChallengeStore.store(userChallenge);


        ChallengeGroupUserExp entity = ChallengeGroupUserExp
                .create(challenge.getChallengeGroup(), user);
        challengeGroupUserExpStore.store(entity);

        // 챌린지 그룹 누적 참여자수 증가
        challenge.getChallengeGroup().addParticipants();
    }

    /**
     * 챌린지 인증하기 <p>
     * 1. ChallengeVerification 테이블에 데이터 추가 <br>
     * 2. Challenge 엔티티에서 필요참여횟수 가져오기 <br>
     * 3. UserChallenge 엔티티에서 참여횟수 가져오기 <br>
     * 4. 참여횟수와 필요참여횟수가 같으면 챌린지 완료로 변경
     */
    @Transactional
    public ChallengeModel.ChallengeVerificationResult verification(
        Long challengeId,
        Long userId,
        ChallengeCommand.VerificationCreate command
    ) {
        UserChallenge userChallenge = userChallengeReader.getByChallengeIdWithVerificationAndChallenge(
            challengeId, userId);
        if(!userChallenge.getUser().getId().equals(userId)) {
            throw new IllegalArgumentException("해당 챌린지에 참여한 유저가 아닙니다.");
        }

        AddUserExpByVerificationEvent event = userChallenge.addChallengeVerification(command);

        // 챌린지 경험치 획득 로직 (유저, 챌린지그룹-유저 경험치)
        addUserExpByVerificationUseCase.invoke(event);

        // 챌린지 RequiredCount 가져오기 위해 챌린지 정보 가져온다
        Challenge challenge = userChallenge.getChallenge();

        return ChallengeModel.ChallengeVerificationResult
            .of(challenge.getRequiredCount(), userChallenge.getChallengeVerifications().size(),
                challenge.getOnceExp());
    }

    /**
     * 진행중인 챌린지 페이징 조회
     */
    @Transactional(readOnly = true)
    public Page<UserChallengeModel.Current> getCurrentChallenges(Long userId,
                                                                 Pageable pageable) {
        Page<UserChallenge> userChallengePage = userChallengeReader
            .getCurrentChallengePageByUserId(userId, pageable);

        List<Long> userChallengeIds = userChallengePage.map(UserChallenge::getId).getContent();
        Map<Long, Boolean> reviewWrittenMap = challengeReviewReader
            .getReviewWrittenMapByUserChallengeId(userChallengeIds);

        return userChallengePage.map(
            m -> UserChallengeModel.Current.from(m, reviewWrittenMap.get(m.getId())));
    }

    /**
     * 완료한 챌린지 페이징 조회
     */
    @Transactional(readOnly = true)
    public Page<UserChallengeModel.Complete> getCompleteChallenges(Long userId,
                                                                   Pageable pageable) {
        Page<UserChallenge> userChallengePage = userChallengeReader
            .getCompletedChallengePageByUserId(userId, pageable);

        List<Long> userChallengeIds = userChallengePage.map(UserChallenge::getId).getContent();
        Map<Long, Boolean> reviewWrittenMap = challengeReviewReader
            .getReviewWrittenMapByUserChallengeId(userChallengeIds);

        return userChallengePage.map(
            m -> UserChallengeModel.Complete.from(m, reviewWrittenMap.get(m.getId())));
    }
}
