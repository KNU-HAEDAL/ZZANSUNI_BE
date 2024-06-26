package org.haedal.zzansuni.core.api;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ApiResponse<T> {
    private Result result;
    private T data;
    private String message;
    private String errorCode;

    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
                .result(Result.SUCCESS)
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> success(T data, String message) {
        return ApiResponse.<T>builder()
                .result(Result.SUCCESS)
                .data(data)
                .message(message)
                .build();
    }

    public static ApiResponse<Void> fail(String errorCode, String message) {
        return ApiResponse.<Void>builder()
                .result(Result.FAIL)
                .errorCode(errorCode)
                .message(message)
                .build();
    }

    public static ApiResponse<Void> fail(ErrorCode errorCode) {
        return ApiResponse.<Void>builder()
                .result(Result.FAIL)
                .errorCode(errorCode.name())
                .message(errorCode.getMessage())
                .build();
    }

    enum Result {
        SUCCESS, FAIL
    }
}
