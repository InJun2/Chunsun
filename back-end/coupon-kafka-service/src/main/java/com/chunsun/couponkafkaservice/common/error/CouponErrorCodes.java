package com.chunsun.couponkafkaservice.common.error;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CouponErrorCodes implements ErrorCode {

    INVALID_REQUEST(BAD_REQUEST, "COMMON4001", "올바르지 않은 요청입니다."),
    INVALID_AUTHORITY(FORBIDDEN, "COUPON4002", "해당 리소스에 접근할 권한이 없습니다."),
    MISSING_AUTHORIZATION_HEADER(UNAUTHORIZED, "COUPON4003", "Authorization 헤더가 누락되었습니다."),
    INVALID_BEARER_TOKEN(UNAUTHORIZED, "COUPON4004", "올바른 Bearer 토큰이 필요합니다."),
    FORBIDDEN_ACCESS(FORBIDDEN, "COUPON4005", "관리자 권한이 필요합니다."),

    INVALID_COUPON_DELETE_REQUEST(BAD_REQUEST, "COMMON4006", "존재하지 않는 쿠폰입니다."),
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
