package com.yxw.managesystem.service.impl;

import com.yxw.managesystem.entity.Major;
import com.yxw.managesystem.entity.Teacher;
import com.yxw.managesystem.mapper.TeacherMapper;
import com.yxw.managesystem.service.ITeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 教师表 服务实现类
 * </p>
 *
 * @author yyd
 * @since 2023-06-14
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public boolean addTeachers(List<Teacher> teacherList) {
        try {
            for (Teacher teacher : teacherList) {
                teacherMapper.insert(teacher);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
