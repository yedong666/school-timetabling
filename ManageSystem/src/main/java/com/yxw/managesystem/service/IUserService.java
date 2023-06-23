package com.yxw.managesystem.service;

import com.yxw.managesystem.common.Result;

public interface IUserService {
    Result login(String account, String password);

    Result getUser(String username);
}
