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
 * 教师表
 * </p>
 *
 * @author yyd
 * @since 2023-06-14
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel(value = "Teacher对象", description = "教师表")
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("教师id")
    @TableId(value = "teacher_id", type = IdType.AUTO)
    private Integer teacherId;

    private String teacherName;

    private String problemId;
}
