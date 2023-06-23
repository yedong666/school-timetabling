package com.yxw.managesystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 问题表
 * </p>
 *
 * @author yyd
 * @since 2023-06-23
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel(value = "Problem对象", description = "问题表")
public class Problem implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("问题id")
    @TableId(value = "problem_id", type = IdType.AUTO)
    private Integer problemId;

    @ApiModelProperty("问题uuid")
    private String problemUuid;

    @ApiModelProperty("发起排课的用户id")
    private Integer systemUserId;

    @ApiModelProperty("发起时间")
    private LocalDateTime createTime;


}
