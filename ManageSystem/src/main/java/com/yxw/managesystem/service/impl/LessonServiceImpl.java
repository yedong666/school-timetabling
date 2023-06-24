package com.yxw.managesystem.service.impl;

import com.yxw.managesystem.entity.Lesson;
import com.yxw.managesystem.mapper.LessonMapper;
import com.yxw.managesystem.service.ILessonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 课程的课时安排表 服务实现类
 * </p>
 *
 * @author yyd
 * @since 2023-06-18
 */
@Service
public class LessonServiceImpl extends ServiceImpl<LessonMapper, Lesson> implements ILessonService {

    @Autowired
    private LessonMapper lessonMapper;

    @Override
    public List<Lesson> getAllLessons(String problemId) {
        try {
            return lessonMapper.selectAll(problemId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Lesson> getLessonsByStudentId(String problemId, Integer studentId) {
        try {
            return lessonMapper.getLessonsByStudentId(problemId, studentId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
