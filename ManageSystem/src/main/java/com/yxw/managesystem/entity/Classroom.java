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
 * 教室信息表
 * </p>
 *
 * @author yyd
 * @since 2023-05-24
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel(value = "Classroom对象", description = "教室信息表")
public class Classroom implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "classroom_id", type = IdType.AUTO)
    private Integer classroomId;

    private String classroomDesc;

    @ApiModelProperty("教室容量")
    private Integer classroomCapacity;


}
