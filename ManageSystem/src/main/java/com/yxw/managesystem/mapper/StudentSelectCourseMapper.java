package com.yxw.managesystem.mapper;

import com.yxw.managesystem.entity.StudentSelectCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 学生与课程关系(多对多关系) Mapper 接口
 * </p>
 *
 * @author yyd
 * @since 2023-06-14
 */
@Mapper
public interface StudentSelectCourseMapper extends BaseMapper<StudentSelectCourse> {
    List<StudentSelectCourse> selectAll();
}
