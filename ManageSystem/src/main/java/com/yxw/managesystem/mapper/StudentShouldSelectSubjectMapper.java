package com.yxw.managesystem.mapper;

import com.yxw.managesystem.entity.StudentShouldSelectSubject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 学生与教学科目关联表(多对多关系) Mapper 接口
 * </p>
 *
 * @author yyd
 * @since 2023-05-20
 */
@Mapper
public interface StudentShouldSelectSubjectMapper extends BaseMapper<StudentShouldSelectSubject> {
    List<Integer> getStudentIdsSelectSubject(@Param("subjectName") String subjectName);
}
