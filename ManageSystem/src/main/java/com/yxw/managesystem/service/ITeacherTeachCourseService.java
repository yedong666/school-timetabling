package com.yxw.managesystem.service;

import com.yxw.managesystem.entity.TeacherTeachCourse;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 教师与课程关系(一对多关系) 服务类
 * </p>
 *
 * @author yyd
 * @since 2023-06-14
 */
public interface ITeacherTeachCourseService extends IService<TeacherTeachCourse> {

    List<TeacherTeachCourse> getAllTeacherTeachCourses(String problemId);
}
