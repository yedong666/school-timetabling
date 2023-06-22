package com.yxw.managesystem.vo;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 登录成功后返回的视图对象
 */
@Data
@Accessors(chain = true)
public class LoginVo implements Serializable {
    private String userName;
    private String role;
    private String realName;
    private String token;
    private Integer roleId;
}
