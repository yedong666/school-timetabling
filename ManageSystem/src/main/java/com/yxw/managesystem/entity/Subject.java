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
 * @since 2023-05-20
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


}
