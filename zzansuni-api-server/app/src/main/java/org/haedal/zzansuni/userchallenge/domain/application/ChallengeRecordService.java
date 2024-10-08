package org.haedal.zzansuni.userchallenge.domain.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.haedal.zzansuni.challengegroup.domain.Challenge;
import org.haedal.zzansuni.challengegroup.domain.port.ChallengeReader;
import org.haedal.zzansuni.userchallenge.domain.port.ChallengeVerificationReader;
import org.haedal.zzansuni.userchallenge.domain.port.UserChallengeReader;
import org.haedal.zzansuni.userchallenge.domain.ChallengeVerification;
import org.haedal.zzansuni.userchallenge.domain.UserChallenge;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class ChallengeRecordService {
    private final ChallengeReader challengeReader;
    private final UserChallengeReader userChallengeReader;
    private final ChallengeVerificationReader challengeVerificationReader;


    /**
     * 챌린지 기록 가져오기
     */
    @Transactional(readOnly = true)
    public UserChallengeModel.Record getChallengeRecord(Long userId, Long challengeId) {
        Challenge challenge = challengeReader.getById(challengeId);
        UserChallenge userChallenge
                = userChallengeReader.getByUserIdAndChallengeId(userId, challengeId);
        List<ChallengeVerification> challengeVerifications
                = challengeVerificationReader.findByUserChallengeId(userChallenge.getId());
        return UserChallengeModel.Record.from(challenge, challengeVerifications);

    }

    /**
     * 챌린지 기록 상세 가져오기
     */
    @Transactional(readOnly = true)
    public ChallengeVerificationModel.Main getChallengeRecordDetail(Long recordId) {
        ChallengeVerification challengeVerification = challengeVerificationReader.getById(recordId);
        return ChallengeVerificationModel.Main.from(challengeVerification);
    }


}
