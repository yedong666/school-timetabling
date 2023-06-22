package com.yxw.managesystem.aspect;

import com.alibaba.fastjson.JSON;
import com.yxw.managesystem.annotation.RoleLevel;
import com.yxw.managesystem.common.util.JwtUtil;
import com.yxw.managesystem.common.util.ThrowExceptionUtil;
import com.yxw.managesystem.enums.ExceptionTypeEnum;
import com.yxw.managesystem.vo.LoginVo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 用户访问接口前检验用户是否有对应的访问权限
 */
@Aspect
@Component
public class CheckRoleAspect {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Pointcut("@annotation(com.yxw.managesystem.annotation.RoleLevel)")
    public void pointCut() {}

    @Around(value = "pointCut()")
    public Object checkRole(ProceedingJoinPoint joinPoint) throws Throwable {
        //拿到请求
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        String token = request.getHeader(JwtUtil.getTokenHeader());

        // 获取切点注解中的参数值
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        // 获取注解Action
        RoleLevel annotation = method.getAnnotation(RoleLevel.class);
        String role = annotation.value();
        LoginVo loginVo = (LoginVo) redisTemplate.opsForValue().get(token);

        assert loginVo != null;
        if(!loginVo.getRole().equals(role)){
            System.out.println("权限不足");
            ThrowExceptionUtil.throwException(ExceptionTypeEnum.ROLE_LEVEL_TOO_LOW);
        }
        System.out.println("权限校验通过");
        return joinPoint.proceed();

    }

}
