package org.haedal.zzansuni.userchallenge.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.haedal.zzansuni.common.controller.PagingRequest;
import org.haedal.zzansuni.common.controller.PagingResponse;
import org.haedal.zzansuni.userchallenge.controller.ChallengeRes.ChallengeCompleteResponse;
import org.haedal.zzansuni.core.api.ApiResponse;
import org.haedal.zzansuni.common.domain.ImageUploader;
import org.haedal.zzansuni.challengegroup.domain.ChallengeCommand;
import org.haedal.zzansuni.userchallenge.domain.application.ChallengeRecordService;
import org.haedal.zzansuni.userchallenge.domain.application.UserChallengeModel;
import org.haedal.zzansuni.userchallenge.domain.application.UserChallengeService;
import org.haedal.zzansuni.global.jwt.JwtUser;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Tag(name = "challenge", description = "챌린지 API")
@RequiredArgsConstructor
@RestController
@Slf4j
public class ChallengeController {

    private final ChallengeRecordService challengeRecordService;
    private final UserChallengeService userChallengeService;
    private final ImageUploader imageUploader;

    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "챌린지 참여", description = "챌린지에 참여한다.")
    @PostMapping("/api/challenges/{challengeId}/join")
    public ApiResponse<Void> challengeParticipation(
        @PathVariable Long challengeId,
        @AuthenticationPrincipal JwtUser jwtUser
    ) {
        userChallengeService.participateChallenge(jwtUser.getId(), challengeId);
        return ApiResponse.success(null, "챌린지 참여에 성공하였습니다.");
    }

    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "챌린지 인증", description = "챌린지에 인증한다.")
    @PostMapping("/api/challenges/{challengeId}/verification")
    public ApiResponse<ChallengeRes.ChallengeVerificationResponse> challengeVerification(
        @AuthenticationPrincipal JwtUser jwtUser,
        @PathVariable Long challengeId,
        @RequestPart("body") ChallengeReq.Verification request,
        @RequestPart("image") MultipartFile image
    ) {
        ChallengeCommand.Verificate command = request.toCommand(image);
        String imageUrl = imageUploader.upload(command.getImage());
        ChallengeCommand.VerificationCreate afterUpload = command.afterUpload(imageUrl);
        var model = userChallengeService.verification(challengeId, jwtUser.getId(), afterUpload);
        var response = ChallengeRes.ChallengeVerificationResponse.from(model);
        return ApiResponse.success(response, "챌린지 인증에 성공하였습니다.");
    }



    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "챌린지 기록 조회", description = "챌린지 기록을 조회한다.")
    @GetMapping("/api/challenges/{challengeId}/record")
    public ApiResponse<ChallengeRes.ChallengeRecordResponse> getChallengeRecord(
        @PathVariable Long challengeId,
        @AuthenticationPrincipal JwtUser jwtUser
    ) {
        ChallengeRes.ChallengeRecordResponse response = ChallengeRes.ChallengeRecordResponse.from(
            challengeRecordService.getChallengeRecord(jwtUser.getId(), challengeId)
        );
        return ApiResponse.success(response, "챌린지 기록 조회에 성공하였습니다.");
    }


    @Operation(summary = "챌린지 기록 상세 조회", description = "챌린지 기록 상세를 조회한다.")
    @GetMapping("/api/challenges/record/{recordId}")
    public ApiResponse<ChallengeRes.ChallengeRecordDetailDto> getChallengeRecordDetail(
        @PathVariable Long recordId,
        @AuthenticationPrincipal JwtUser jwtUser
    ) {
        ChallengeRes.ChallengeRecordDetailDto response = ChallengeRes.ChallengeRecordDetailDto.from(
            challengeRecordService.getChallengeRecordDetail(recordId)
        );
        log.info("response: {}", response);
        return ApiResponse.success(response, "챌린지 기록 상세 조회에 성공하였습니다.");
    }

    @Operation(summary = "진행중인 챌린지 조회", description = "진행중인 챌린지 조회한다.")
    @GetMapping("/api/user/challenges/currents")
    public ApiResponse<PagingResponse<ChallengeRes.ChallengeCurrentResponse>> getChallengeCurrentsPaging(
        @Valid PagingRequest pagingRequest,
        @AuthenticationPrincipal JwtUser jwtUser
    ) {
        Page<UserChallengeModel.Current> page = userChallengeService.getCurrentChallenges(
            jwtUser.getId(), pagingRequest.toPageable());

        PagingResponse<ChallengeRes.ChallengeCurrentResponse> response = PagingResponse.from(
            page, ChallengeRes.ChallengeCurrentResponse::from
        );
        return ApiResponse.success(response);
    }

    @Operation(summary = "완료한 챌린지 조회", description = "완료한 챌린지 페이징 조회한다.")
    @GetMapping("/api/user/challenges/completes")
    public ApiResponse<PagingResponse<ChallengeCompleteResponse>> getChallengeCompletesPaging(
        @Valid PagingRequest pagingRequest,
        @AuthenticationPrincipal JwtUser jwtUser
    ) {
        Page<UserChallengeModel.Complete> page = userChallengeService.getCompleteChallenges(
            jwtUser.getId(), pagingRequest.toPageable());

        PagingResponse<ChallengeCompleteResponse> response = PagingResponse.from(
            page, ChallengeRes.ChallengeCompleteResponse::from
        );
        return ApiResponse.success(response);
    }
}
