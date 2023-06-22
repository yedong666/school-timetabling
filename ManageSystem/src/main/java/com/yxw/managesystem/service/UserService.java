package com.yxw.managesystem.service;

import com.yxw.managesystem.common.Result;
import com.yxw.managesystem.vo.LoginVo;

import java.util.Map;

public interface UserService {
    Result login(String account, String password);

    Result getUser(String username);
}
