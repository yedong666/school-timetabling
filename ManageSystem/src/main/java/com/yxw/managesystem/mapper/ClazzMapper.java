package com.yxw.managesystem.mapper;

import com.yxw.managesystem.entity.Clazz;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 教学班表 Mapper 接口
 * </p>
 *
 * @author yyd
 * @since 2023-06-18
 */
@Mapper
public interface ClazzMapper extends BaseMapper<Clazz> {
    List<Clazz> selectAll(String problemId);
    void empty();
}
