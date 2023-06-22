package com.yxw.managesystem.mapper;

import com.yxw.managesystem.entity.Clazz;
import com.yxw.managesystem.entity.Subject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 教学科目表 Mapper 接口
 * </p>
 *
 * @author yyd
 * @since 2023-06-14
 */
@Mapper
public interface SubjectMapper extends BaseMapper<Subject> {

    /**
     * 计算总共有多少学生有某门课
     */
    Integer countStudentHaveSubject(Integer subjectId);

    /**
     * 获得所有有某门课的教学班
     */
    List<Integer> selectAllClazzHaveSubject(Integer subjectId);

    List<Subject> selectAll();
}
