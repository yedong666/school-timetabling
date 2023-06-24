package com.yxw.managesystem.mapper;

import com.yxw.managesystem.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 课程表(与教学科目表为一对多关系) Mapper 接口
 * </p>
 *
 * @author yyd
 * @since 2023-06-18
 */
@Mapper
public interface CourseMapper extends BaseMapper<Course> {
    List<Course> selectAll(String problemId);
    void empty();
    void updateFromWeekAndToWeek(String problemId, Integer courseId, Integer fromWeek, Integer toWeek);
    List<Integer> getSelectedCourseIdsByStudentName(String problemId, String studentName);
}
