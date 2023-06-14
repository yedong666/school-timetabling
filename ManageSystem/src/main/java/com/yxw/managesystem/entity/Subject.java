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
 * 教学科目表
 * </p>
 *
 * @author yyd
 * @since 2023-06-14
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel(value = "Subject对象", description = "教学科目表")
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("科目(学科)id")
    @TableId(value = "subject_id", type = IdType.AUTO)
    private Integer subjectId;

    private String subjectName;

    private String subjectDesc;

    @ApiModelProperty("对应开设课程最大选课人数")
    private Integer subjectStuCapacity;

    @ApiModelProperty("1: 公共基础课 2:")
    private Integer subjectType;

    @ApiModelProperty("这门课需要上多少学时")
    private Integer subjectLessonNum;

    @ApiModelProperty("这门课每周需要上几节课（多少学时）")
    private Integer subjectLessonPerWeek;


}
