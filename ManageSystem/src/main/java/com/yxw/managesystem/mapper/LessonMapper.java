package com.yxw.managesystem.mapper;

import com.yxw.managesystem.entity.Lesson;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 课程的课时安排表 Mapper 接口
 * </p>
 *
 * @author yyd
 * @since 2023-06-18
 */
@Mapper
public interface LessonMapper extends BaseMapper<Lesson> {
    List<Lesson> selectAll(String problemId);
    void empty();
}
