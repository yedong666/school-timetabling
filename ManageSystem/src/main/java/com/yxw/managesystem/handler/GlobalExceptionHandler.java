package com.yxw.managesystem.handler;

import com.yxw.managesystem.common.Result;
import com.yxw.managesystem.common.exception.BusinessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 异常处理类
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result errorHandler(Exception e) {
        e.printStackTrace();
        return Result.fail();
    }

    @ExceptionHandler(BusinessException.class)
    public Result businessErrorHandler(BusinessException e){
        return Result.fail(e);
    }

}
