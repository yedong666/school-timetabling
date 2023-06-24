package com.yxw.managesystem.service.impl;

import com.yxw.managesystem.entity.TeacherTeachCourse;
import com.yxw.managesystem.mapper.TeacherTeachCourseMapper;
import com.yxw.managesystem.service.ITeacherTeachCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 教师与课程关系(一对多关系) 服务实现类
 * </p>
 *
 * @author yyd
 * @since 2023-06-14
 */
@Service
public class TeacherTeachCourseServiceImpl extends ServiceImpl<TeacherTeachCourseMapper, TeacherTeachCourse> implements ITeacherTeachCourseService {

    @Autowired
    private TeacherTeachCourseMapper teacherTeachCourseMapper;

    @Override
    public List<TeacherTeachCourse> getAllTeacherTeachCourses(String problemId) {
        try {
            return teacherTeachCourseMapper.selectAll(problemId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
