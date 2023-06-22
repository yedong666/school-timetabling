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
 * 学生与课程关系(多对多关系)
 * </p>
 *
 * @author yyd
 * @since 2023-06-14
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("student_select_course")
@ApiModel(value = "StudentSelectCourse对象", description = "学生与课程关系(多对多关系)")
public class StudentSelectCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "student_select_course_id", type = IdType.AUTO)
    private Integer studentSelectCourseId;

    private Integer studentId;

    private Integer courseId;

    private String problemId;
}
