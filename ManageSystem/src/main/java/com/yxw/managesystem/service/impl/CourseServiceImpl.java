package com.yxw.managesystem.service.impl;

import com.yxw.managesystem.entity.Course;
import com.yxw.managesystem.entity.CourseForClazz;
import com.yxw.managesystem.entity.Subject;
import com.yxw.managesystem.mapper.CourseForClazzMapper;
import com.yxw.managesystem.mapper.CourseMapper;
import com.yxw.managesystem.mapper.SubjectMapper;
import com.yxw.managesystem.service.ICourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 课程表(与教学科目表为一对多关系) 服务实现类
 * </p>
 *
 * @author yyd
 * @since 2023-06-18
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

    @Autowired
    private SubjectMapper subjectMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CourseForClazzMapper courseForClazzMapper;

    @Override
    public List<Course> getAllCourses(String problemId) {
        try {
            return courseMapper.selectAll(problemId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean generateCourses(String problemId) {
        try {
            List<Subject> subjects = subjectMapper.selectAll(problemId);
            int courseCnt = 0; // 当前课程是第几门课, 用于给课程命名
            int autoCourseId = -1; // 当前课程的自增主键 id
            for (Subject subject : subjects) {
                // 计算应该为这门教学科目开几门课
                // 满足以下约束
                // 1. 一个教学班的所有学生在都选同一 course
                // 2. 选一个 course 的学生数 <= subjectCapacity
                int subjectStuCapacity = subject.getSubjectStuCapacity();
                // 选了这门课的教学班
                List<Integer> clazzIdList =
                        subjectMapper.selectAllClazzHaveSubject(problemId, subject.getSubjectId());
                int curRestCapacity = 0; // 当前课程还能容纳多少学生
                int clazzSize = 50;
                for (Integer clazzId : clazzIdList) {
                    // 当前课程剩余容量无法容纳这个教学班了, 开一个新 course
                    if (curRestCapacity < clazzSize) {
                        courseCnt++;
                        Course course = new Course();
                        course.setProblemId(problemId);
                        course.setSubjectId(subject.getSubjectId());
                        course.setCourseName(subject.getSubjectName() + courseCnt);
                        courseMapper.insert(course);
                        autoCourseId = course.getCourseId(); // 获得生成的自增主键值
                        curRestCapacity = subjectStuCapacity;
                    }
                    curRestCapacity -= clazzSize;
                    // 记录这个 course 的目标班级有 clazz
                    CourseForClazz courseForClazz = new CourseForClazz();
                    courseForClazz.setProblemId(problemId);
                    courseForClazz.setCourseId(autoCourseId);
                    courseForClazz.setClazzId(clazzId);
                    courseForClazzMapper.insert(courseForClazz);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
