package com.yxw.managesystem.service.impl;

import com.yxw.managesystem.entity.StudentSelectCourse;
import com.yxw.managesystem.mapper.StudentSelectCourseMapper;
import com.yxw.managesystem.service.IStudentSelectCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生与课程关系(多对多关系) 服务实现类
 * </p>
 *
 * @author yyd
 * @since 2023-05-24
 */
@Service
public class StudentSelectCourseServiceImpl extends ServiceImpl<StudentSelectCourseMapper, StudentSelectCourse> implements IStudentSelectCourseService {

}
