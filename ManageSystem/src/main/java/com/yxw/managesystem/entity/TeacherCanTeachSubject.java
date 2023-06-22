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
 * 教师与教学科目关联表(多对多关系)
 * </p>
 *
 * @author yyd
 * @since 2023-06-14
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("teacher_can_teach_subject")
@ApiModel(value = "TeacherCanTeachSubject对象", description = "教师与教学科目关联表(多对多关系)")
public class TeacherCanTeachSubject implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "teacher_can_teach_subject_id", type = IdType.AUTO)
    private Integer teacherCanTeachSubjectId;

    private Integer teacherId;

    private Integer subjectId;

    private String problemId;
}
