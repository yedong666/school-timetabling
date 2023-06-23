package com.yxw.managesystem.service.impl;

import com.yxw.managesystem.entity.Student;
import com.yxw.managesystem.mapper.StudentMapper;
import com.yxw.managesystem.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
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

    @Autowired
    private StudentMapper studentMapper;

    // TODO XML 里用 foreach 批量插入
    @Override
    public boolean addStudents(List<Student> studentList) {
        try {
            for (Student student : studentList) {
                studentMapper.insert(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    @Nullable
    public List<Student> getAllStudents(String problemId) {
        try {
            return studentMapper.selectAll(problemId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
