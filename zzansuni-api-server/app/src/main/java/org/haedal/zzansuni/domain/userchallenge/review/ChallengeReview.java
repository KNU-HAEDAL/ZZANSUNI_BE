package org.haedal.zzansuni.domain.userchallenge.review;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.haedal.zzansuni.domain.BaseTimeEntity;
import org.haedal.zzansuni.domain.challengegroup.challenge.ChallengeCommand;
import org.haedal.zzansuni.domain.userchallenge.UserChallenge;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
public class ChallengeReview extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_challenge_id", nullable = false)
    private UserChallenge userChallenge;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Integer rating;

    // 쿼리 성능을 위해 비정규화
    @Column(nullable = false)
    private Long challengeGroupId;

    public static ChallengeReview create(UserChallenge userChallenge, ChallengeCommand.ReviewCreate command) {
        Long challengeGroupId = userChallenge.getChallenge().getChallengeGroupId();
        return ChallengeReview.builder()
            .userChallenge(userChallenge)
            .content(command.getContent())
            .rating(command.getRating())
            .challengeGroupId(challengeGroupId)
            .build();
    }

}
