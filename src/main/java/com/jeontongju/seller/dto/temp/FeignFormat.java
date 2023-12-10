package com.jeontongju.seller.dto.temp;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 domain : all
 detail : Feign 통신시 사용되는 Format Dto
 method : Feign
 comment : null column의 경우 값이 안보이는 속성 추가
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FeignFormat<T> {
    private final Integer code;
    private final String message;
    private final String detail;
    private final String failure;
    private final T data;
    @Builder
    public FeignFormat(Integer code, String message, String detail, String failure, Object data) {
        this.code = code;
        this.message = message;
        this.detail = detail;
        this.failure = failure;
        this.data = (T) data;
    }
}