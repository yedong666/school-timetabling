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
 * @since 2023-05-24
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

    private Integer subjectId;


}
