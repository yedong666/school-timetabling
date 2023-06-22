package com.yxw.managesystem.enums;

public enum ResultCodeEnum {

    /* 成功状态码 */
    SUCCESS("200", "成功"),

    /* 失败状态码 */
    FAIL("500", "失败");

    private String code;

    private String message;

    ResultCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

}

