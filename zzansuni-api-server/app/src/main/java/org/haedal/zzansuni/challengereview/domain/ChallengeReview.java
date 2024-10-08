package org.haedal.zzansuni.challengereview.domain;

import jakarta.persistence.*;
import lombok.*;
import org.haedal.zzansuni.common.domain.BaseTimeEntity;
import org.haedal.zzansuni.userchallenge.domain.UserChallenge;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
@Table(
    indexes = {
        @Index(
            name = "idx_challenge_review_challenge_group_id_rating",
            columnList = "challenge_group_id, rating"
        ),
    }
)
public class ChallengeReview extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_challenge_id", nullable = false)
    private UserChallenge userChallenge;

    @Column(nullable = false, length = 1000)
    private String content;

    @Column(nullable = false)
    private Integer rating;

    // 쿼리 성능을 위해 비정규화
    @Column(nullable = false)
    private Long challengeGroupId;

    @Column(nullable = false)
    private Integer difficulty;

    @Column(nullable = false)
    private Integer achievement;

    public void update(ChallengeReviewCommand.Upsert command) {
        this.content = command.getContent();
        this.rating = command.getRating();
        this.difficulty = command.getDifficulty();
        this.achievement = command.getAchievement();
    }

    public static ChallengeReview create(UserChallenge userChallenge, ChallengeReviewCommand.Upsert command) {
        Long challengeGroupId = userChallenge.getChallenge().getChallengeGroupId();
        return ChallengeReview.builder()
            .userChallenge(userChallenge)
            .content(command.getContent())
            .rating(command.getRating())
            .challengeGroupId(challengeGroupId)
            .difficulty(command.getDifficulty())
            .achievement(command.getAchievement())
            .build();
    }

}
