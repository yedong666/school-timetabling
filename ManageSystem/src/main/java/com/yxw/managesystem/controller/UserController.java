package com.yxw.managesystem.controller;


import com.yxw.managesystem.annotation.RoleLevel;
import com.yxw.managesystem.common.Result;
import com.yxw.managesystem.service.UserService;
import com.yxw.managesystem.vo.LoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yyd
 * @since 2023-05-13
 */
@RestController
@Api(tags = "用户管理接口")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("根据账号密码登录")
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public Result login(@Param("username") String username, @Param("password") String password){
        System.out.println("登录接口访问成功");
        return userService.login(username, password);
    }

    @ApiOperation("根据账号获取用户信息")
    @RoleLevel("ADMIN, STUDENT, TEACHER")
    @RequestMapping(value = "getUser", method = RequestMethod.GET)
    public Result getUser(@Param("username") String username){
        System.out.println("登录接口访问成功");
        return userService.getUser(username);
    }



}
