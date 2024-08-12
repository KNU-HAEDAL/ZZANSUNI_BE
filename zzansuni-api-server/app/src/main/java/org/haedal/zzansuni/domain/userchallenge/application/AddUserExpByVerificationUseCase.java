package org.haedal.zzansuni.domain.userchallenge.application;

import lombok.RequiredArgsConstructor;
import org.haedal.zzansuni.domain.challengegroup.port.ChallengeGroupReader;
import org.haedal.zzansuni.domain.userchallenge.AddUserExpByVerificationEvent;
import org.haedal.zzansuni.domain.userchallenge.ChallengeGroupUserExp;
import org.haedal.zzansuni.domain.userchallenge.port.ChallengeGroupUserExpReader;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class AddUserExpByVerificationUseCase {
    private final ChallengeGroupUserExpReader challengeGroupUserExpReader;

    @Transactional
    public void invoke(AddUserExpByVerificationEvent event) {
        Long challengeGroupId = event.getChallengeGroupId();
        Long userId = event.getUserId();

        ChallengeGroupUserExp challengeGroupUserExp = challengeGroupUserExpReader
                .findByChallengeGroupIdAndUserId(challengeGroupId, userId).orElseThrow();
        challengeGroupUserExp.addExp(event.getAcquiredExp());
    }
}
