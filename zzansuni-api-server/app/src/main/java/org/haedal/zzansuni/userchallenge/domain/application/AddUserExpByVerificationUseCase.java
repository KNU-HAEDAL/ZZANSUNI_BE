package org.haedal.zzansuni.userchallenge.domain.application;

import lombok.RequiredArgsConstructor;
import org.haedal.zzansuni.user.domain.User;
import org.haedal.zzansuni.user.domain.port.UserReader;
import org.haedal.zzansuni.userchallenge.domain.port.ChallengeGroupUserExpReader;
import org.haedal.zzansuni.userchallenge.domain.ChallengeGroupUserExp;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class AddUserExpByVerificationUseCase {
    private final UserReader userReader;
    private final ChallengeGroupUserExpReader challengeGroupUserExpReader;

    @Transactional
    public void invoke(AddUserExpByVerificationEvent event) {
        Long userId = event.getUserId();
        Long challengeGroupId = event.getChallengeGroupId();

        User user = userReader.getById(userId);
        ChallengeGroupUserExp challengeGroupUserExp = challengeGroupUserExpReader
                .findByChallengeGroupIdAndUserId(challengeGroupId, userId).orElseThrow();

        user.addExp(event.getAcquiredExp());
        challengeGroupUserExp.addExp(event.getAcquiredExp());
    }
}
