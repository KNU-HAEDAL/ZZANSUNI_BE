package org.haedal.zzansuni.domain.challengegroup.userchallenge;

import lombok.RequiredArgsConstructor;
import org.haedal.zzansuni.domain.challengegroup.challenge.Challenge;
import org.haedal.zzansuni.domain.challengegroup.challenge.ChallengeReader;
import org.haedal.zzansuni.domain.user.User;
import org.haedal.zzansuni.domain.user.UserReader;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserChallengeService {

    private final UserChallengeStore userChallengeStore;
    private final UserChallengeReader userChallengeReader;
    private final UserReader userReader;
    private final ChallengeReader challengeReader;

    /**
     * 챌린지 참여하기 1. 유저와 챌린지 정보를 받아서 UserChallenge 테이블에 데이터 추가
     */
    public void participateChallenge(Long userId,
        UserChallengeCommand.Participate participateInfo) {
        User user = userReader.getById(userId);
        Challenge challenge = challengeReader.getById(participateInfo.getChallengeId());
        UserChallenge userChallenge = UserChallenge.from(challenge, user);
        userChallengeStore.store(userChallenge);
    }

}
