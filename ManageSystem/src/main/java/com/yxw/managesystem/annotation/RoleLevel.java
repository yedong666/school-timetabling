package com.yxw.managesystem.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RoleLevel {

    /**
     * @return 访问权限(定义某接口需要什么权限才可访问)
     */
    String value() default "admin";
}
