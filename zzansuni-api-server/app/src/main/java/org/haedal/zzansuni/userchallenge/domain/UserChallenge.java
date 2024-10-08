package org.haedal.zzansuni.userchallenge.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.haedal.zzansuni.common.domain.BaseTimeEntity;
import org.haedal.zzansuni.challengegroup.domain.Challenge;
import org.haedal.zzansuni.challengegroup.domain.ChallengeCommand;
import org.haedal.zzansuni.user.domain.User;
import org.haedal.zzansuni.userchallenge.domain.application.AddUserExpByVerificationEvent;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
@Table(
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_user_challenge_challenge_user",
            columnNames = {"challenge_id", "user_id"}
        )
    }
)
public class UserChallenge extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "challenge_id", nullable = false)
    private Challenge challenge;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ChallengeStatus status;

    @Column(nullable = false)
    private LocalDate activeStartDate;

    @Column(nullable = false)
    private LocalDate activeEndDate;

    private LocalDate successDate;

    @OneToMany(mappedBy = "userChallenge", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChallengeVerification> challengeVerifications = new ArrayList<>();

    public static UserChallenge create(Challenge challenge, User user, LocalDate activeStartDate, LocalDate activeEndDate) {
        return UserChallenge.builder()
            .challenge(challenge)
            .user(user)
            .activeStartDate(activeStartDate)
            .activeEndDate(activeEndDate)
            .status(ChallengeStatus.PROCEEDING)
            .build();
    }

    public Long getChallengeId() {
        return this.challenge.getId();
    }

    /**
     * 챌린지 인증 추가
     * 1. 챌린지 인증을 추가
     * 2. 챌린지 인증을 추가하면서 챌린지 인증에 따른 경험치를 추가
     * 3. 챌린지를 완료한 경우 챌린지 완료로 변경, 경험치 추가
     * 4. 챌린지그룹-경험치 추가 이벤트를 반환(경험치 증가는 이벤트 핸들러에서 처리)
     */
    public AddUserExpByVerificationEvent addChallengeVerification(ChallengeCommand.VerificationCreate command) {
        ChallengeVerification challengeVerification = ChallengeVerification.create(command, this);
        this.challengeVerifications.add(challengeVerification);

        int acquiredExp = this.challenge.getOnceExp();

        // 만약 챌린지 인증 참여횟수와 필요참여획수가 같으면 챌린지 완료로 변경
        if (this.challengeVerifications.size() == this.challenge.getRequiredCount()) {
            user.addExp(challenge.getSuccessExp());
            this.completeChallengeStatus();
        }
        return AddUserExpByVerificationEvent
                .of(user.getId(), acquiredExp, challenge.getChallengeGroupId());
    }


    private void completeChallengeStatus() {
        this.status = ChallengeStatus.SUCCESS;
    }

    /**
     * 챌린지 성공일자 가져오기
     * [챌린지 인증]을 통해 성공한 가장 최근 날짜를 가져온다.
     */
    public Optional<LocalDate> getRecentSuccessDate() {
        return this.challengeVerifications.stream()
            .map(ChallengeVerification::getCreatedAt)
            .max(LocalDateTime::compareTo)
            .map(LocalDateTime::toLocalDate);
    }


}
