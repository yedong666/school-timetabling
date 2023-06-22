package com.yxw.managesystem.common.planner;

import com.yxw.managesystem.entity.*;
import com.yxw.managesystem.mapper.CourseMapper;
import com.yxw.managesystem.mapper.LessonMapper;
import com.yxw.managesystem.mapper.TeacherTeachCourseMapper;
import lombok.Getter;
import lombok.Setter;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.core.config.solver.SolverConfig;

import java.time.Duration;
import java.util.*;

@Getter
@Setter
@PlanningSolution
public class Solution {

    @ValueRangeProvider
    @ProblemFactCollectionProperty
    private List<DWeek> dWeekList;

    @ValueRangeProvider
    @ProblemFactCollectionProperty
    private List<DClassroom> dClassroomList;

    @ValueRangeProvider
    @ProblemFactCollectionProperty
    private List<DClazz> dClazzList;

    @ValueRangeProvider
    @ProblemFactCollectionProperty
    private List<DTeacher> dTeacherList;

    @ValueRangeProvider
    @ProblemFactCollectionProperty
    private List<DTimeSlot> dTimeSlotList;

    @ValueRangeProvider
    @ProblemFactCollectionProperty
    private List<DSubject> dSubjectList;

    @PlanningEntityCollectionProperty
    private List<DCourse> dCourseList;

    @PlanningEntityCollectionProperty
    private List<DLesson> dLessonList;

    @PlanningScore
    private HardSoftScore score;

    public enum Status {
        FINISHED,
        SCHEDULED,
        ON_GOING,
        FAILED,
        IMPOSSIBLE,
    }

    public static Solution initProblem(
        List<Course> courseList,
        List<Clazz> clazzList,
        List<Classroom> classroomList,
        List<Subject> subjectList,
        List<Teacher> teacherList,
        List<TeacherCanTeachSubject> teacherCanTeachSubjectList,
        List<CourseForClazz> courseForClazzList
    ) {
        Solution solution = new Solution();

        // 初始化 classroomlist
        List<DClassroom> dClassroomList = new ArrayList<>();
        for (Classroom classroom : classroomList) {
            DClassroom dClassroom = new DClassroom();
            dClassroom.setId(classroom.getClassroomId());
            dClassroom.setCapacity(classroom.getClassroomCapacity());
            dClassroomList.add(dClassroom);
        }
        solution.setDClassroomList(dClassroomList);

        // 初始化 subjectlist
        Map<Integer, DSubject> dSubjectMap = new HashMap<>();
        List<DSubject> dSubjectList = new ArrayList<>();
        for (Subject subject : subjectList) {
            DSubject dSubject = new DSubject();
            Integer subjectId = subject.getSubjectId();
            dSubject.setId(subjectId);
            dSubject.setSubjectStuCapacity(subject.getSubjectStuCapacity());
            dSubject.setSubjectLessonNum(subject.getSubjectLessonNum());
            dSubject.setSubjectLessonPerWeek(subject.getSubjectLessonPerWeek());
            dSubjectMap.put(subjectId, dSubject);
            dSubjectList.add(dSubject);
        }
        solution.setDSubjectList(dSubjectList);

        // 初始化 clazzlist
        Map<Integer, DClazz> dClazzMap = new HashMap<>();
        List<DClazz> dClazzList = new ArrayList<>();
        for (Clazz clazz : clazzList) {
            Integer clazzId = clazz.getClazzId();
            DClazz dClazz = new DClazz();
            dClazz.setId(clazzId);
            dClazzMap.put(clazzId, dClazz);
            dClazzList.add(dClazz);
        }
        solution.setDClazzList(dClazzList);

        // 初始化 teacherlist
        List<DTeacher> dTeacherList = new ArrayList<>();
        for (Teacher teacher : teacherList) {
            DTeacher dTeacher = new DTeacher();
            dTeacher.setId(teacher.getTeacherId());
            // 找出这个老师能够教的课
            Set<DSubject> availableSubjects = new HashSet<>();
            for (TeacherCanTeachSubject teacherCanTeachSubject : teacherCanTeachSubjectList) {
                if (teacherCanTeachSubject.getTeacherId().equals(teacher.getTeacherId())) {
                    DSubject availableSubject = new DSubject();
                    availableSubject.setId(teacherCanTeachSubject.getSubjectId());
                    availableSubjects.add(availableSubject);
                }
            }
            dTeacher.setAvailableSubjects(availableSubjects);
            dTeacherList.add(dTeacher);
        }
        solution.setDTeacherList(dTeacherList);

        // TODO 暂且默认从 1 周上到 5 周
        // 初始化 weeklist
        List<DWeek> dWeekList = new ArrayList<>();
        for (int i = 1; i <= 5; i ++) {
            DWeek dWeek = new DWeek();
            dWeek.setIndex(i);
            dWeekList.add(dWeek);
        }
        solution.setDWeekList(dWeekList);

        // 初始化 timeslotlist
        // 一周 5 天，一天四个时间段可以上课 => 20 个时间槽 TODO 不考虑晚上，周末的课？
        List<DTimeSlot> dTimeSlotList = new ArrayList<>(20);
        for (int i = 1; i <= 20; i ++) {
            DTimeSlot dTimeSlot = new DTimeSlot();
            dTimeSlot.setIndex(i);
            dTimeSlotList.add(dTimeSlot);
        }
        solution.setDTimeSlotList(dTimeSlotList);

        // 初始化 courselist 和 lessonlist
        List<DCourse> dCourseList = new ArrayList<>();
        List<DLesson> allDLessonList = new ArrayList<>();
        int cnt = 1;
        for (Course course : courseList) {
            Integer courseId = course.getCourseId();
            DCourse dCourse = new DCourse();
            dCourse.setId(courseId);
            // 计算要上几周
            Integer subjectId = course.getSubjectId();
            DSubject dSubject = dSubjectMap.get(subjectId);
            dCourse.setDSubject(dSubject);
            int lessonNum = dSubject.getSubjectLessonNum();
            int lessonPerWeek = dSubject.getSubjectLessonPerWeek();
            // TODO 按道理按周排课，每周应该上一样的课
            int weeks = lessonNum % lessonPerWeek == 0
                    ? lessonNum / lessonPerWeek
                    : lessonNum / lessonPerWeek + 1;
            dCourse.setWeeks(weeks);
            // 按课时数生成课时（lesson），按周排课，因而生成一周即可
            List<DLesson> dLessonList = new ArrayList<>();
            for (int i = 0; i < lessonPerWeek; i ++) {
                DLesson dLesson = new DLesson();
                dLesson.setId(cnt ++);
                dLesson.setDCourse(dCourse);
                dLessonList.add(dLesson);
            }
            dCourse.setLessons(dLessonList);
            allDLessonList.addAll(dLessonList);
            dCourseList.add(dCourse);
            // 计算
            List<DClazz> forClazz = new ArrayList<>();
            for (CourseForClazz courseForClazz : courseForClazzList) {
                if (courseForClazz.getCourseId().equals(courseId)) {
                    DClazz dClazz = dClazzMap.get(courseForClazz.getClazzId());
                    assert dClazz != null;
                    forClazz.add(dClazz);
                }
            }
            dCourse.setForClazz(forClazz);
        }
        solution.setDCourseList(dCourseList);
        solution.setDLessonList(allDLessonList);
        return solution;
    }

    /**
     * 求解此 problem, 仅用于测试
     */
    public Solution solve(int waitSecs) {
        SolverFactory<Solution> solverFactory = SolverFactory.create(new SolverConfig()
                .withSolutionClass(Solution.class)
                .withEntityClasses(DCourse.class, DLesson.class)
                .withConstraintProviderClass(ConstraintsProvider.class)
                .withTerminationSpentLimit(Duration.ofSeconds(waitSecs)));

        Solver<Solution> solver = solverFactory.buildSolver();
        return solver.solve(this);
    }

    /**
     * 将结果持久化到数据库中
     */
    public void persistResult(
            String problemId,
            CourseMapper courseMapper,
            TeacherTeachCourseMapper teacherTeachCourseMapper,
            LessonMapper lessonMapper
    ) {
        // 写入每门课由哪个老师教
        // 写入每门课的开始和结束周数
        int teacherTeachCourseId = 1;
        for (DCourse dCourse : dCourseList) {
            DTeacher dTeacher = dCourse.getDTeacher();
            TeacherTeachCourse teacherTeachCourse = new TeacherTeachCourse();
            teacherTeachCourse.setProblemId(problemId);
            teacherTeachCourse.setTeacherTeachCourseId(teacherTeachCourseId ++);
            teacherTeachCourse.setCourseId(dCourse.getId());
            teacherTeachCourse.setTeacherId(dTeacher.getId());
            teacherTeachCourseMapper.insert(teacherTeachCourse);

            int fromWeek = dCourse.getDWeek().getIndex();
            int toWeek = fromWeek + dCourse.getWeeks();
            courseMapper.updateFromWeekAndToWeek(problemId, dCourse.getId(), fromWeek, toWeek);
        }

        // 写入课时安排
        for (DLesson dLesson : dLessonList) {
            DCourse dCourse = dLesson.getDCourse();
            DClassroom dClassroom = dLesson.getDClassroom();
            DTimeSlot dTimeSlot = dLesson.getDTimeSlot();

            Lesson lesson = new Lesson();
            lesson.setProblemId(problemId);
            lesson.setLessonId(dLesson.getId());
            lesson.setCourseId(dCourse.getId());
            lesson.setClassroomId(dClassroom.getId());
            lesson.setTimeslotId(dTimeSlot.getIndex());
            lessonMapper.insert(lesson);
        }
    }
}
