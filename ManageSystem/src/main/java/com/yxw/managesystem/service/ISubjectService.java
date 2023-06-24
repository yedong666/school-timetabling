package com.yxw.managesystem.service;

import com.yxw.managesystem.entity.Student;
import com.yxw.managesystem.entity.Subject;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.annotation.Nullable;
import java.util.List;

/**
 * <p>
 * 教学科目表 服务类
 * </p>
 *
 * @author yyd
 * @since 2023-06-14
 */
public interface ISubjectService extends IService<Subject> {

    boolean addSubjects(List<Subject> subjectList);

    @Nullable
    List<Subject> getAllSubjects(String problemId);
}
