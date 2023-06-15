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
 * 学生表
 * </p>
 *
 * @author yyd
 * @since 2023-06-14
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel(value = "Student对象", description = "学生表")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("学生id")
    @TableId(value = "student_id", type = IdType.AUTO)
    private Integer studentId;

    @ApiModelProperty("用户名")
    private String studentName;

    @ApiModelProperty("入学时间")
    private LocalDateTime studentEnterTime;

    @ApiModelProperty("第几学期")
    private Integer studentYearNo;

    @ApiModelProperty("学生班级")
    private Integer studentClass;

    @ApiModelProperty("专业id")
    private Integer majorId;


}
