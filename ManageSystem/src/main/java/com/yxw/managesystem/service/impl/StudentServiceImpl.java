package com.yxw.managesystem.service.impl;

import com.yxw.managesystem.entity.Student;
import com.yxw.managesystem.mapper.StudentMapper;
import com.yxw.managesystem.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 学生表 服务实现类
 * </p>
 *
 * @author yyd
 * @since 2023-06-18
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {
    @Override
    public boolean addStudents(List<Student> studentList) {
        throw new UnsupportedOperationException();
    }
}
