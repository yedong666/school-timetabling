package com.yxw.managesystem.service;

import com.yxw.managesystem.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.annotation.Nullable;
import java.util.List;

/**
 * <p>
 * 学生表 服务类
 * </p>
 *
 * @author yyd
 * @since 2023-06-18
 */
public interface IStudentService extends IService<Student> {

    public boolean addStudents(List<Student> studentList);

    @Nullable
    public List<Student> getAllStudents(String problemId);
}
