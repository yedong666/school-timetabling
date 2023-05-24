package com.yxw.managesystem.mapper;

import com.yxw.managesystem.entity.TeacherCanTeachSubject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 教师与教学科目关联表(多对多关系) Mapper 接口
 * </p>
 *
 * @author yyd
 * @since 2023-05-24
 */
@Mapper
public interface TeacherCanTeachSubjectMapper extends BaseMapper<TeacherCanTeachSubject> {

}
