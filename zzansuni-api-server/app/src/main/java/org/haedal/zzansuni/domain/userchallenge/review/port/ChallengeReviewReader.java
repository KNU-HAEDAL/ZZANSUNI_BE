package org.haedal.zzansuni.domain.userchallenge.review.port;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.haedal.zzansuni.domain.userchallenge.review.ChallengeReview;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ChallengeReviewReader {

    ChallengeReview getByUserChallengeId(Long userChallengeId);

    Optional<ChallengeReview> findByUserChallengeId(Long userChallengeId);

    Map<Long, Boolean> getReviewWrittenMapByUserChallengeId(List<Long> userChallengeIds);

    Page<ChallengeReview> getChallengeReviewPageByChallengeGroupId(Long challengeGroupId,
        Pageable pageable);

    Page<ChallengeReview> getChallengeReviewPage(Pageable pageable);

    List<ChallengeReview> findByChallengeGroupId(Long challengeGroupId);

}
