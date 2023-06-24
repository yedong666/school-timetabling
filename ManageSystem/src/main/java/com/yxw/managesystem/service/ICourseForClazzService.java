package com.yxw.managesystem.service;

import com.yxw.managesystem.entity.CourseForClazz;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程与教学班关联表, 记录一门课主要为哪些教学班开设 服务类
 * </p>
 *
 * @author yyd
 * @since 2023-06-18
 */
public interface ICourseForClazzService extends IService<CourseForClazz> {

    List<CourseForClazz> getAllCourseForClazzs(String problemId);
}
