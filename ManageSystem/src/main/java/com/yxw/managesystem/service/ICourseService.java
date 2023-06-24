package com.yxw.managesystem.service;

import com.yxw.managesystem.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程表(与教学科目表为一对多关系) 服务类
 * </p>
 *
 * @author yyd
 * @since 2023-06-18
 */
public interface ICourseService extends IService<Course> {

    List<Course> getAllCourses(String problemId);

    /**
     * 为每门 subject 对应生成 courses
     */
    boolean generateCourses(String problemId);
}
