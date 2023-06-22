package com.yxw.managesystem.service.impl;


import com.yxw.managesystem.common.planner.DLesson;
import com.yxw.managesystem.common.planner.Solution;
import com.yxw.managesystem.entity.Classroom;
import com.yxw.managesystem.entity.Course;
import com.yxw.managesystem.entity.Lesson;
import com.yxw.managesystem.entity.Subject;
import com.yxw.managesystem.mapper.*;
import com.yxw.managesystem.service.TimeTablingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service()
public class TimeTablingServiceImpl implements TimeTablingService {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private MajorMapper majorMapper;

    @Autowired
    private SubjectMapper subjectMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private TrainingPlanMapper trainingPlanMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private TeacherCanTeachSubjectMapper teacherCanTeachSubjectMapper;

    @Autowired
    private ClassroomMapper classroomMapper;

    @Override
    public Boolean scheduleLessons() {
        List<Subject> subjectList = subjectMapper.selectAll();
        List<Course> courseList = courseMapper.selectAll();
        List<Classroom> classroomList = classroomMapper.selectAll();
//        Solution problem = Solution.initProblem(courseList, classroomList, subjectList);

        //为每个course分配teacher; 为每个lesson分配classroom和timeslot
//        Solution result = Solution.solve(problem);
//        List<DLesson> dLessonList = result.getDLessonList();
//        List<Lesson> lessonList = dLessonList.stream().map(Lesson::new).collect(Collectors.toList());
        return null;
    }
}
