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
 * 学生与教学科目关联表(多对多关系)
 * </p>
 *
 * @author yyd
 * @since 2023-05-20
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("student_should_select_subject")
@ApiModel(value = "StudentShouldSelectSubject对象", description = "学生与教学科目关联表(多对多关系)")
public class StudentShouldSelectSubject implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "student_should_select_subject_id", type = IdType.AUTO)
    private Integer studentShouldSelectSubjectId;

    private Integer studentId;

    private Integer subjectId;


}
