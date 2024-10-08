package org.haedal.zzansuni.core.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    COMMON_SYSTEM_ERROR("일시적인 오류가 발생했습니다. 잠시 후 다시 시도해주세요."), // 장애 상황
    COMMON_INVALID_PARAMETER("요청한 값이 올바르지 않습니다."),
    COMMON_ENTITY_NOT_FOUND("존재하지 않는 엔티티입니다."),
    COMMON_ILLEGAL_STATUS("잘못된 상태값입니다."),
    COMMON_INVALID_REQUEST("잘못된 요청입니다."),
    COMMON_INVALID_METHOD("허용되지 않은 메소드입니다."),
    COMMON_INVALID_MEDIA_TYPE("지원하지 않는 미디어 타입입니다."),
    COMMON_NOT_ALLOWED("허용되지 않은 요청입니다.");

    private final String message;
}
