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
 * 课时时间表
 * </p>
 *
 * @author yyd
 * @since 2023-05-24
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel(value = "Timeslot对象", description = "课时时间表")
public class Timeslot implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "timeslot_id", type = IdType.AUTO)
    private Integer timeslotId;

    private String fromTime;

    private String toTime;


}
