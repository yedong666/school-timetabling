package com.yxw.managesystem.filter;


import com.alibaba.fastjson.JSON;
import com.yxw.managesystem.common.Result;
import com.yxw.managesystem.common.util.JwtUtil;
import com.yxw.managesystem.common.util.ThrowExceptionUtil;
import com.yxw.managesystem.enums.ExceptionTypeEnum;
import com.yxw.managesystem.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

@Component
public class AuthorizationFilter extends OncePerRequestFilter {
    /**
     * 白名单
     */
    private static final String[] WHITELIST =
            {"/doc.html","/static/**", "/user/login", "/webjars/",
                "/swagger-resources", "/favicon.ico","/v2/"
            };

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        checkPermission(request, response, chain);
    }

    /**
     * 登录校验
     */
    private void checkPermission(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException {
        //是否允许通过
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        try {
            if(method.equals("OPTIONS") || checkWhitelist(requestURI)){
                //白名单路径或者OPTIONS请求直接放行
                System.out.println("URL: " + requestURI + " 已放行" + "    method: " + method);
                chain.doFilter(request, response);
                return;
            }

            String token = request.getHeader(JwtUtil.getTokenHeader());
            if (token != null){
                if(JwtUtil.verifyToken(token)){
                    //验证token是否被篡改
                    LoginVo loginVo = (LoginVo) redisTemplate.opsForValue().get(token);
                    if(loginVo != null){
                        //token续期
                        redisTemplate.opsForValue().set(token, loginVo, 8L, TimeUnit.HOURS);
                        System.out.println("URL: " + requestURI + " 已放行" + "    method: " + method);
                        System.out.println(loginVo);
                        chain.doFilter(request, response);
                        return;
                    }
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("URL: " + requestURI + " 未认证" + "    method: " + method);
        response.setCharacterEncoding("utf-8");
        try(PrintWriter writer = response.getWriter()) {
            writer.write(JSON.toJSONString(Result.fail(ExceptionTypeEnum.USER_IS_NOT_LOGIN)));
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    private boolean checkWhitelist(String requestURI) {
        for (String whitelistedUrl : WHITELIST) {
            if (requestURI.startsWith(whitelistedUrl)) {
                return true;
            }
        }
        return false;
    }


}
