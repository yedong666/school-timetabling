package com.yxw.managesystem.service;

import com.yxw.managesystem.entity.TeacherCanTeachSubject;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.annotation.Nullable;
import java.util.List;

/**
 * <p>
 * 教师与教学科目关联表(多对多关系) 服务类
 * </p>
 *
 * @author yyd
 * @since 2023-06-14
 */
public interface ITeacherCanTeachSubjectService extends IService<TeacherCanTeachSubject> {

    boolean addTeacherCanTeachSubjectList(List<TeacherCanTeachSubject> teacherCanTeachSubjectList);

    @Nullable
    List<TeacherCanTeachSubject> getAllTeacherCanTeachSubject(String problemId);
}
