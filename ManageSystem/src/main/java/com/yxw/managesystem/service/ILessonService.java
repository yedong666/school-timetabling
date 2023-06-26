package com.yxw.managesystem.service;

import com.yxw.managesystem.entity.Lesson;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程的课时安排表 服务类
 * </p>
 *
 * @author yyd
 * @since 2023-06-18
 */
public interface ILessonService extends IService<Lesson> {

    List<Lesson> getAllLessons(String problemId);

    List<Lesson> getLessonsByStudentId(String problemId, Integer studentId, Integer week);
}
