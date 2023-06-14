package com.yxw.managesystem.mapper;

import com.yxw.managesystem.entity.Major;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 培养计划表 Mapper 接口
 * </p>
 *
 * @author yyd
 * @since 2023-06-14
 */
@Mapper
public interface MajorMapper extends BaseMapper<Major> {
    List<Major> selectAll();
}
