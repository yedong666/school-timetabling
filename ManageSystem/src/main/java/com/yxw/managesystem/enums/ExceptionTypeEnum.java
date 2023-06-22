package com.yxw.managesystem.enums;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExceptionTypeEnum {
    USER_IS_NULL("001", "用户不存在"),
    ROLE_LEVEL_TOO_LOW("002", "权限不足"),

    USER_IS_NOT_LOGIN("003", "用户未登录");

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误信息
     */
    private String message;
}
