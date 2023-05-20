package com.yxw.managesystem.service.impl;

import com.yxw.managesystem.entity.User;
import com.yxw.managesystem.mapper.UserMapper;
import com.yxw.managesystem.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yyd
 * @since 2023-05-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
