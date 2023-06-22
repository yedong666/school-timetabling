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
 * 培养计划表
 * </p>
 *
 * @author yyd
 * @since 2023-06-14
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("training_plan")
@ApiModel(value = "TrainingPlan对象", description = "培养计划表")
public class TrainingPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "training_plan_id", type = IdType.AUTO)
    private Integer trainingPlanId;

    @ApiModelProperty("专业id")
    private Integer majorId;

    @ApiModelProperty("第几学期")
    private Integer yearNo;

    private Integer subjectId;

    private String problemId;
}
