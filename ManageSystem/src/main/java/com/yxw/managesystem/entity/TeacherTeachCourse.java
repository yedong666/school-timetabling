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
 * 教师与课程关系(一对多关系)
 * </p>
 *
 * @author yyd
 * @since 2023-06-14
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("teacher_teach_course")
@ApiModel(value = "TeacherTeachCourse对象", description = "教师与课程关系(一对多关系)")
public class TeacherTeachCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "teacher_teach_course_id", type = IdType.AUTO)
    private Integer teacherTeachCourseId;

    private Integer teacherId;

    private Integer courseId;


}
