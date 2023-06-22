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
 * 课程的课时安排表
 * </p>
 *
 * @author yyd
 * @since 2023-06-18
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel(value = "Lesson对象", description = "课程的课时安排表")
public class Lesson implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("课时id")
    @TableId(value = "lesson_id", type = IdType.AUTO)
    private Integer lessonId;

    private Integer courseId;

    private Integer timeslotId;

    private Integer classroomId;


}
