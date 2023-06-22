package com.yxw.managesystem.service.impl;

import com.yxw.managesystem.entity.TeacherTeachCourse;
import com.yxw.managesystem.mapper.TeacherTeachCourseMapper;
import com.yxw.managesystem.service.ITeacherTeachCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
