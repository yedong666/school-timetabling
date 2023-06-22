package com.yxw.managesystem.mapper;

import com.yxw.managesystem.entity.CourseForClazz;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 课程与教学班关联表, 记录一门课主要为哪些教学班开设 Mapper 接口
 * </p>
 *
 * @author yyd
 * @since 2023-06-18
 */
@Mapper
public interface CourseForClazzMapper extends BaseMapper<CourseForClazz> {
    List<CourseForClazz> selectAll();
    void empty();
}
