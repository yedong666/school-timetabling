package com.yxw.managesystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 教学班表
 * </p>
 *
 * @author yyd
 * @since 2023-06-18
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel(value = "Clazz对象", description = "教学班表")
public class Clazz implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("教学班id")
    @TableId(value = "clazz_id", type = IdType.AUTO)
    private Integer clazzId;

    @ApiModelProperty("教学班名")
    private String clazzName;

    private String problemId;
}
