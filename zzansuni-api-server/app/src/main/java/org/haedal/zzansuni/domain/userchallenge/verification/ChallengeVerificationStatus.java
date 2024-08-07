package org.haedal.zzansuni.domain.userchallenge.verification;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ChallengeVerificationStatus {
    WAITING("대기중"),
    APPROVED("승인"),
    REJECTED("거절");

    private final String korean;
}
