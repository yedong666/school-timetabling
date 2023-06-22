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
 * 课程表(与教学科目表为一对多关系)
 * </p>
 *
 * @author yyd
 * @since 2023-06-18
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel(value = "Course对象", description = "课程表(与教学科目表为一对多关系)")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("课程id")
    @TableId(value = "course_id", type = IdType.AUTO)
    private Integer courseId;

    @ApiModelProperty("课程名")
    private String courseName;

    private Integer subjectId;

    @ApiModelProperty("从第几周开始上 in")
    private Integer fromWeek;

    @ApiModelProperty("上到第几周 ex")
    private Integer toWeek;

    private String problemId;
}
