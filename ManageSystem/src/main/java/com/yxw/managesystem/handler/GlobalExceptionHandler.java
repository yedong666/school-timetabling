package com.yxw.managesystem.handler;

import com.yxw.managesystem.common.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 异常处理类
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result errorHandler(Exception e) {
        return Result.fail();
    }

}
