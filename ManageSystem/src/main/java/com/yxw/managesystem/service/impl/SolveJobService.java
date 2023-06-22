package com.yxw.managesystem.service.impl;

import com.yxw.managesystem.common.planner.ConstraintsProvider;
import com.yxw.managesystem.common.planner.DCourse;
import com.yxw.managesystem.common.planner.DLesson;
import com.yxw.managesystem.common.planner.Solution;
import com.yxw.managesystem.entity.*;
import com.yxw.managesystem.mapper.*;
import com.yxw.managesystem.service.ISolveJobService;
import org.optaplanner.core.api.solver.SolverManager;
import org.optaplanner.core.api.solver.SolverStatus;
import org.optaplanner.core.config.solver.SolverConfig;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class SolveJobService implements ISolveJobService {

    private static SolverManager<Solution, String> __SOLVE_MANAGER;
    private static Map<String, Solution> __SOLUTION_MANAGER;
    private static Set<String> __FAILED_PROBLEMS;

    private static final long WAIT_SECS = 60;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private ClazzMapper clazzMapper;

    @Autowired
    private ClassroomMapper classroomMapper;

    @Autowired
    private SubjectMapper subjectMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private TeacherCanTeachSubjectMapper teacherCanTeachSubjectMapper;

    @Autowired
    private CourseForClazzMapper courseForClazzMapper;

    private SolverManager<Solution, String> getSolverManager() {
        if (__SOLVE_MANAGER == null) {
            __SOLVE_MANAGER = SolverManager.create(new SolverConfig()
                    .withSolutionClass(Solution.class)
                    .withEntityClasses(DCourse.class, DLesson.class)
                    .withConstraintProviderClass(ConstraintsProvider.class)
                    .withTerminationSpentLimit(Duration.ofSeconds(WAIT_SECS)));
        }
        return __SOLVE_MANAGER;
    }

    private Map<String, Solution> getSolutionMap() {
        if (__SOLUTION_MANAGER == null) {
            __SOLUTION_MANAGER = new ConcurrentHashMap<>();
        }
        return __SOLUTION_MANAGER;
    }

    private Set<String> getFailedProblems() {
        if (__FAILED_PROBLEMS == null) {
            __FAILED_PROBLEMS = new ConcurrentSkipListSet<>();
        }
        return __FAILED_PROBLEMS;
    }

    @Override
    public Solution generateProblem(String problemId) {
        List<Course> courseList = courseMapper.selectAll(problemId);
        List<Clazz> clazzList = clazzMapper.selectAll(problemId);
        List<Classroom> classroomList = classroomMapper.selectAll(problemId);
        List<Subject> subjectList = subjectMapper.selectAll(problemId);
        List<Teacher> teacherList = teacherMapper.selectAll(problemId);
        List<TeacherCanTeachSubject> teacherCanTeachSubjectList = teacherCanTeachSubjectMapper.selectAll(problemId);
        List<CourseForClazz> courseForClazzList = courseForClazzMapper.selectAll(problemId);
        return Solution.initProblem(
                courseList,
                clazzList,
                classroomList,
                subjectList,
                teacherList,
                teacherCanTeachSubjectList,
                courseForClazzList
        );
    }

    @Override
    public void addSolveJob(String problemId, Solution problem) {
        getSolverManager().solve(
                problemId,
                problem,
                solution -> {
                    // 计算完成后将最佳结果放到 solutionMap 中
                    getSolutionMap().put(problemId, solution);
                },
                (failedProblemId, exception) -> {
                    // 计算出错, 则将 problemId 加入 failedProblems
                    getFailedProblems().add(failedProblemId);
                });
    }

    @Override
    public Solution.Status querySolveJobStatus(String problemId) {
        if (getFailedProblems().contains(problemId)) {
            return Solution.Status.FAILED;
        }
        if (getSolutionMap().containsKey(problemId)) {
            return Solution.Status.FINISHED;
        }
        SolverStatus solverStatus = getSolverManager().getSolverStatus(problemId);
        if (solverStatus == SolverStatus.SOLVING_ACTIVE) {
            return Solution.Status.ON_GOING;
        } else if (solverStatus == SolverStatus.SOLVING_SCHEDULED) {
            return Solution.Status.SCHEDULED;
        } else return Solution.Status.IMPOSSIBLE;
    }
}
