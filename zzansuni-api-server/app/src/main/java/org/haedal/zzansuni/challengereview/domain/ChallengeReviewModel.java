package org.haedal.zzansuni.challengereview.domain;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Builder;
import org.haedal.zzansuni.challengegroup.domain.ChallengeGroup;
import org.haedal.zzansuni.challengegroup.domain.Challenge;
import org.haedal.zzansuni.user.domain.UserModel;
import org.haedal.zzansuni.userchallenge.domain.UserChallenge;

public class ChallengeReviewModel {

    @Builder
    public record ChallengeReviewWithUserInfo(
        Long challengeId,
        String challengeTitle,
        UserModel.Main user,
        String content,
        Integer rating
    ) {

        public static ChallengeReviewWithUserInfo from(ChallengeReview challengeReview) {
            var userModel = UserModel.Main.from(challengeReview.getUserChallenge().getUser());
            Challenge challenge = challengeReview.getUserChallenge().getChallenge();
            ChallengeGroup challengeGroup = challenge.getChallengeGroup();

            return ChallengeReviewWithUserInfo.builder()
                .challengeId(challenge.getId())
                .challengeTitle(challengeGroup.getTitle())
                .user(userModel)
                .content(challengeReview.getContent())
                .rating(challengeReview.getRating())
                .build();
        }
    }

    @Builder
    public record ChallengeReviewWithChallenge(
        Long challengeId,
        String challengeTitle,
        Integer challengeDifficulty,
        UserModel.Main user,
        String content,
        Integer rating,
        Integer difficulty,
        Integer achievement,
        LocalDateTime createdAt
    ) {

        public static ChallengeReviewWithChallenge from(ChallengeReview challengeReview) {
            var userModel = UserModel.Main.from(challengeReview.getUserChallenge().getUser());
            UserChallenge userChallenge = challengeReview.getUserChallenge();
            Challenge challenge = userChallenge.getChallenge();
            ChallengeGroup challengeGroup = challenge.getChallengeGroup();

            return ChallengeReviewWithChallenge.builder()
                .challengeId(userChallenge.getChallengeId())
                .challengeTitle(challengeGroup.getTitle())
                .challengeDifficulty(challenge.getDifficulty())
                .user(userModel)
                .content(challengeReview.getContent())
                .rating(challengeReview.getRating())
                .difficulty(challengeReview.getDifficulty())
                .achievement(challengeReview.getAchievement())
                .createdAt(challengeReview.getCreatedAt())
                .build();
        }

    }

    @Builder
    public record Score(
        Float averageRating,
        Map<Integer, Integer> ratingCount
    ) {

        public static Score of(List<ChallengeReview> challengeReviews) {
            // key: rating, value: count
            // rating은 1,2,3,4,5 이며 value는 각각의 rating이 몇개인지 count
            Map<Integer, Integer> ratingCount = new HashMap<>();
            for (int i = 1; i <= 5; i++) {
                ratingCount.put(i, 0);
            }
            challengeReviews.forEach(challengeReview -> {
                var rating = challengeReview.getRating();
                ratingCount.put(rating, ratingCount.get(rating) + 1);
            });

            var averageRating = challengeReviews.stream()
                .mapToInt(ChallengeReview::getRating)
                .average()
                .orElse(0);
            return Score.builder()
                .averageRating((float) averageRating)
                .ratingCount(ratingCount)
                .build();
        }

        public static Score from(Map<Integer, Integer> ratingCount) {
            double valuesCount = ratingCount.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
            if(valuesCount == 0){
                valuesCount = 1;
            } // 0으로 나누는 경우를 방지
            var averageRating = ratingCount.entrySet().stream()
                .mapToDouble(entry -> entry.getKey() * entry.getValue())
                .sum() / valuesCount;
            return Score.builder()
                .averageRating((float) averageRating)
                .ratingCount(ratingCount)
                .build();
        }
    }

}
