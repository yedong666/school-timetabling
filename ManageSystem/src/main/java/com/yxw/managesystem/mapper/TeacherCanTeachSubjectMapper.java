package com.yxw.managesystem.mapper;

import com.yxw.managesystem.entity.TeacherCanTeachSubject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 教师与教学科目关联表(多对多关系) Mapper 接口
 * </p>
 *
 * @author yyd
 * @since 2023-06-14
 */
@Mapper
public interface TeacherCanTeachSubjectMapper extends BaseMapper<TeacherCanTeachSubject> {
    List<TeacherCanTeachSubject> selectAll();
}
