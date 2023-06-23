package com.yxw.managesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yxw.managesystem.common.Result;
import com.yxw.managesystem.common.util.JwtUtil;
import com.yxw.managesystem.common.util.PasswordSecureUtil;
import com.yxw.managesystem.entity.User;
import com.yxw.managesystem.mapper.UserMapper;
import com.yxw.managesystem.service.IUserService;
import com.yxw.managesystem.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public Result login(String userName, String password) {
        if(Objects.isNull(userName)){
            return Result.fail("用户名不能为空");
        }
        User user = getUserByUserName(userName);
        if(password.equals(PasswordSecureUtil.decrypt(user.getPassword()))){
            //根据用户信息构建token
            String token = JwtUtil.getToken(user);
            //构建登录返回视图对象
            LoginVo loginVo = new LoginVo().setUserName(user.getUsername()).setToken(token)
                                                .setRole(user.getRole()).setRoleId(user.getRoleId());
            //设置token八小时过期
            redisTemplate.opsForValue().set(token, loginVo, 8L, TimeUnit.HOURS);
            return Result.suc(loginVo);
        }
        return Result.fail("密码错误");
    }

    @Override
    public Result getUser(String username) {
        return Result.suc(getUserByUserName(username));
    }

    private User getUserByUserName(String userName){
        return userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername, userName));
    }
}
