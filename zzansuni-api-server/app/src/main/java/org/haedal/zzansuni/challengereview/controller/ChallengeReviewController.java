package org.haedal.zzansuni.challengereview.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.haedal.zzansuni.challengereview.domain.ChallengeReviewModel.ChallengeReviewWithChallenge;
import org.haedal.zzansuni.challengereview.domain.ChallengeReviewModel.ChallengeReviewWithUserInfo;
import org.haedal.zzansuni.challengereview.domain.ChallengeReviewService;
import org.haedal.zzansuni.common.controller.PagingRequest;
import org.haedal.zzansuni.common.controller.PagingResponse;
import org.haedal.zzansuni.core.api.ApiResponse;
import org.haedal.zzansuni.global.jwt.JwtUser;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Tag(name = "challengeReviews", description = "챌린지 리뷰 관련 API")
@RestController
@RequiredArgsConstructor
public class ChallengeReviewController {

    private final ChallengeReviewService challengeReviewService;


    @Operation(summary = "챌린지 그룹 최근 리뷰 페이징", description = "챌린지 최근 리뷰 페이징 조회.")
    @GetMapping("/api/challengeGroups/reviews")
    public ApiResponse<PagingResponse<ChallengeReviewRes.Info>> getChallengeReviews(
        @Valid PagingRequest pagingRequest
        //TODO SORTING
    ) {
        Page<ChallengeReviewWithUserInfo> page = challengeReviewService.getChallengeReviews(
            pagingRequest.toPageable());

        PagingResponse<ChallengeReviewRes.Info> response = PagingResponse.from(
            page, ChallengeReviewRes.Info::from
        );

        return ApiResponse.success(response);

    }


    @Operation(summary = "챌린지 그룹 리뷰 페이징", description = "챌린지 그룹 하위의 모든 챌린지 리뷰 페이징 조회.")
    @GetMapping("/api/challengeGroups/{challengeGroupId}/reviews")
    public ApiResponse<PagingResponse<ChallengeReviewRes.InfoWithChallenge>> getChallengeReviewsPaging(
        @PathVariable Long challengeGroupId,
        @Valid PagingRequest pagingRequest
        //TODO SORTING
    ) {
        Page<ChallengeReviewWithChallenge> page = challengeReviewService.getChallengeReviewsByGroupId(
            challengeGroupId, pagingRequest.toPageable());

        PagingResponse<ChallengeReviewRes.InfoWithChallenge> response = PagingResponse.from(
            page, ChallengeReviewRes.InfoWithChallenge::from
        );

        return ApiResponse.success(response);

    }

    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "챌린지 리뷰 Upsert", description = "챌린지 리뷰를 생성하거나 수정합니다.")
    @PostMapping("/api/challenges/{challengeId}/reviews")
    public ApiResponse<Long> challengeReviewCreate(
        @PathVariable Long challengeId,
        @AuthenticationPrincipal JwtUser jwtUser,
        @RequestBody ChallengeReviewReq.Create request
    ) {
        Long response = challengeReviewService.upsertReview(request.toCommand(), challengeId,
            jwtUser.getId());
        return ApiResponse.success(response, "챌린지 리뷰 작성에 성공하였습니다.");
    }

    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "챌린지 그룹별 리뷰 평점 조회", description = "챌린지 그룹별 리뷰 평점 조회")
    @GetMapping("/api/challengeGroups/{challengeGroupId}/reviews/score")
    public ApiResponse<ChallengeReviewRes.ScoreResponse> getChallengeGroupReviewScore(
        @PathVariable Long challengeGroupId
    ) {
        var response = ChallengeReviewRes.ScoreResponse.from(
                challengeReviewService.getChallengeGroupReviewScore(challengeGroupId));
        return ApiResponse.success(response, "챌린지 그룹별 리뷰 평점 조회에 성공하였습니다.");
    }
}
