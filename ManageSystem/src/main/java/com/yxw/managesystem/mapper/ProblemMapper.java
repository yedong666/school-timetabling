package com.yxw.managesystem.mapper;

import com.yxw.managesystem.entity.Problem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 问题表 Mapper 接口
 * </p>
 *
 * @author yyd
 * @since 2023-06-23
 */
@Mapper
public interface ProblemMapper extends BaseMapper<Problem> {
    List<Problem> selectAll();
    void empty();
}
