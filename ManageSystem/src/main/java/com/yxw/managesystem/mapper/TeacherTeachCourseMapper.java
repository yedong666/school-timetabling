package com.yxw.managesystem.mapper;

import com.yxw.managesystem.entity.TeacherTeachCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 教师与课程关系(一对多关系) Mapper 接口
 * </p>
 *
 * @author yyd
 * @since 2023-06-14
 */
@Mapper
public interface TeacherTeachCourseMapper extends BaseMapper<TeacherTeachCourse> {
    List<TeacherTeachCourse> selectAll();
}
