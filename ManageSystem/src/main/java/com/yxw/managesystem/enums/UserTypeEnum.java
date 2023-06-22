package com.yxw.managesystem.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserTypeEnum {
    TEACHER("教师");
    private String roleName;
}
