package com.yxw.managesystem.mapper;

import com.yxw.managesystem.entity.StudentSelectCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 学生与课程关系(多对多关系) Mapper 接口
 * </p>
 *
 * @author yyd
 * @since 2023-05-24
 */
@Mapper
public interface StudentSelectCourseMapper extends BaseMapper<StudentSelectCourse> {

}
