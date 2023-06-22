package com.yxw.managesystem.common.util;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTHeader;
import cn.hutool.jwt.JWTUtil;
import com.yxw.managesystem.dto.TokenDto;
import com.yxw.managesystem.entity.User;
import com.yxw.managesystem.enums.UserTypeEnum;

import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    //token生成密钥
    final static private String jwtKey = "JWT_KEY";
    //token请求头
    final static private String tokenHeader = "Authorization";
    public static String getToken(User user){
        Map<String, Object> map = new HashMap<>();
        map.put("role", user.getRole());
        map.put("userName", user.getUsername());
        map.put("roleId", user.getRoleId());
        return JWTUtil.createToken(map, jwtKey.getBytes());
    }

    public static TokenDto parseToken(String token){
        final JWT jwt = JWTUtil.parseToken(token);
        jwt.getHeader(JWTHeader.TYPE);

        TokenDto tokenDto = new TokenDto();
        tokenDto.setRole(jwt.getPayload("role").toString());
        tokenDto.setUsername((String) jwt.getPayload("userName"));
        tokenDto.setRoleId(Integer.parseInt(jwt.getPayload("roleId").toString()));
        return tokenDto;
    }

    public static boolean verifyToken(String token){
       return JWTUtil.verify(token, jwtKey.getBytes());
    }

    public static String getTokenHeader(){
        return tokenHeader;
    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("role", UserTypeEnum.TEACHER.getRoleName());
        map.put("userName", "2020217898");
        map.put("roleId", 1);

        User user = new User();
        user.setRole("teacher");
        user.setRoleId(1);
        user.setUsername("12345");
        String token = getToken(user);
        System.out.println(token);
        System.out.println(parseToken(token));
        System.out.println(verifyToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoyLCJyb2xlSWQiOjEsInVzZXJOYW1lIjoiMjAyMDIxNzg5OCJ9.GRl3MqkFgmOMbNFbRMsb9AU5mXpYzoYc4SEWxG9a8I"));
    }

}
