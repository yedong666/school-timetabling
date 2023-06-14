package com.yxw.managesystem.common.planner;

import com.yxw.managesystem.entity.Classroom;
import com.yxw.managesystem.entity.Course;
import com.yxw.managesystem.entity.Subject;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

//    @ValueRangeProvider
//    @ProblemFactCollectionProperty
//    private List<DTeacher> dTeacherList;

    @ValueRangeProvider
    @ProblemFactCollectionProperty
    private List<DTimeSlot> dTimeSlots;

    @PlanningEntityCollectionProperty
    private List<DCourse> dCourseList;

    @PlanningEntityCollectionProperty
    private List<DLesson> dLessonList;

    @PlanningScore
    private HardSoftScore score;

    public static Solution initProblem(
        List<Course> courseList,
//        List<Teacher> teacherList,
        List<Classroom> classroomList,
        List<Subject> subjectList
    ) {
        Solution solution = new Solution();
        List<DClassroom> dClassroomList = new ArrayList<>();
        for (Classroom classroom : classroomList) {
            DClassroom dClassroom = new DClassroom();
            dClassroom.setId(classroom.getClassroomId());
            dClassroom.setCapacity(classroom.getClassroomCapacity());
            dClassroomList.add(dClassroom);
        }
        solution.setDClassroomList(dClassroomList);

        // TODO 暂且默认从 1 周上到 5 周
        List<DWeek> dWeekList = new ArrayList<>();
        for (int i = 1; i <= 5; i ++) {
            DWeek dWeek = new DWeek();
            dWeek.setIndex(i);
            dWeekList.add(dWeek);
        }
        solution.setDWeekList(dWeekList);

        // 一周 6 天，一天四个时间段可以上课 => 24 个时间槽 TODO 不考虑晚上，周末的课？
        List<DTimeSlot> dTimeSlotList = new ArrayList<>(24);
        for (int i = 1; i <= 24; i ++) {
            DTimeSlot dTimeSlot = new DTimeSlot();
            dTimeSlot.setIndex(i);
            dTimeSlotList.add(dTimeSlot);
        }
        solution.setDTimeSlots(dTimeSlotList);

        Map<Integer, Subject> subjectMap = new HashMap<>();
        for (Subject subject : subjectList) {
            subjectMap.put(subject.getSubjectId(), subject);
        }

        List<DCourse> dCourseList = new ArrayList<>();
        List<DLesson> allDLessonList = new ArrayList<>();
        int cnt = 1;
        for (Course course : courseList) {
            DCourse dCourse = new DCourse();
            dCourse.setId(course.getCourseId());
            // 计算要上几周
            Subject subject = subjectMap.get(course.getSubjectId());
            int lessonNum = subject.getSubjectLessonNum();
            int lessonPerWeek = subject.getSubjectLessonPerWeek();
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
        }
        solution.setDCourseList(dCourseList);
        solution.setDLessonList(allDLessonList);
        return solution;
    }

    public static Solution solve(Solution problem) {
        SolverFactory<Solution> solverFactory = SolverFactory.create(new SolverConfig()
                .withSolutionClass(Solution.class)
                .withEntityClasses(DCourse.class, DLesson.class)
                .withConstraintProviderClass(ConstraintsProvider.class)
                .withTerminationSpentLimit(Duration.ofSeconds(5)));

        Solver<Solution> solver = solverFactory.buildSolver();
        return solver.solve(problem);
    }
}
