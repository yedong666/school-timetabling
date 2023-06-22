package com.yxw.managesystem.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TokenDto {
    private String username;

    private String role;

    private Integer roleId;
}
