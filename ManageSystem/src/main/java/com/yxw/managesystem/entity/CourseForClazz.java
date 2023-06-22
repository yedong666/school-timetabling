package com.yxw.managesystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 课程与教学班关联表, 记录一门课主要为哪些教学班开设
 * </p>
 *
 * @author yyd
 * @since 2023-06-18
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("course_for_clazz")
@ApiModel(value = "CourseForClazz对象", description = "课程与教学班关联表, 记录一门课主要为哪些教学班开设")
public class CourseForClazz implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("课程为教学班开设, 一条记录的 id")
    @TableId(value = "course_for_class_id", type = IdType.AUTO)
    private Integer courseForClassId;

    @ApiModelProperty("课程id")
    private Integer courseId;

    @ApiModelProperty("教学班id")
    private Integer clazzId;

    private String problemId;
}
