package com.yxw.managesystem.common.util;


import com.yxw.managesystem.common.exception.BusinessException;
import com.yxw.managesystem.enums.ExceptionTypeEnum;

public class ThrowExceptionUtil {
    public static void throwException(ExceptionTypeEnum exceptionTypeEnum){
        throw new BusinessException(exceptionTypeEnum.getCode(), exceptionTypeEnum.getMessage());
    }
}
