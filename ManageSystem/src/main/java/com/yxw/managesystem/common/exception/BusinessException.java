package com.yxw.managesystem.common.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 统一异常
 */
@Getter
@AllArgsConstructor
public class BusinessException extends RuntimeException{
    /**
     * 错误码
     */
    private String code;

    /**
     * 错误信息
     */
    private final String message;
}
