package com.yxw.managesystem.controller;

import com.yxw.managesystem.annotation.RoleLevel;
import com.yxw.managesystem.common.Result;
import com.yxw.managesystem.common.planner.Solution;
import com.yxw.managesystem.dto.*;
import com.yxw.managesystem.entity.*;
import com.yxw.managesystem.service.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CenterController {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private IClassroomService classroomService;

    @Autowired
    private IMajorService majorService;

    @Autowired
    private ITeacherService teacherService;

    @Autowired
    private ITeacherCanTeachSubjectService teacherCanTeachSubjectService;

    @Autowired
    private ITrainingPlanService trainingPlanService;

    @Autowired
    private ICourseService courseService;

    @Autowired
    private ISubjectService subjectService;

    @Autowired
    private ICourseForClazzService courseForClazzService;

    @Autowired
    private ILessonService lessonService;

    @Autowired
    private IProblemService problemService;

    @Autowired
    private ITeacherTeachCourseService teacherTeachCourseService;

    @Autowired
    private ISolveJobService solveJobService;

    /////////////////// 排课

    @ApiOperation("添加若干个学生")
    @RoleLevel("ADMIN")
    @RequestMapping(value = "addStudents", method = RequestMethod.POST, produces = "application/json")
    public Result addStudents(@RequestBody StudentList studentList) {
        if (!studentService.addStudents(studentList.getStudentList())) {
            return Result.fail();
        }
        return Result.suc("添加学生成功");
    }

    @ApiOperation("获得所有学生")
    @RoleLevel("ADMIN")
    @RequestMapping(value = "getAllStudents", method = RequestMethod.GET)
    public Result getAllStudents(String problemId) {
        List<Student> students = studentService.getAllStudents(problemId);
        if (students == null) {
            return Result.fail();
        }
        return Result.suc(students);
    }

    @ApiOperation("添加若干个教室")
    @RoleLevel("ADMIN")
    @RequestMapping(value = "addClassrooms", method = RequestMethod.POST, produces = "application/json")
    public Result addClassrooms(@RequestBody ClassroomList classroomList) {
        if (!classroomService.addClassrooms(classroomList.getClassroomList())) {
            return Result.fail();
        }
        return Result.suc("添加教室成功");
    }

    @ApiOperation("获得所有教室")
    @RoleLevel("ADMIN")
    @RequestMapping(value = "getAllClassrooms", method = RequestMethod.GET)
    public Result getAllClassrooms(String problemId) {
        List<Classroom> classrooms = classroomService.getAllClassrooms(problemId);
        if (classrooms == null) {
            return Result.fail();
        }
        return Result.suc(classrooms);
    }

    @ApiOperation("添加若干个专业")
    @RoleLevel("ADMIN")
    @RequestMapping(value = "addMajors", method = RequestMethod.POST, produces = "application/json")
    public Result addMajors(@RequestBody MajorList majorList) {
        if (!majorService.addMajors(majorList.getMajorList())) {
            return Result.fail();
        }
        return Result.suc("添加专业成功");
    }

    @ApiOperation("获得所有专业")
    @RoleLevel("ADMIN")
    @RequestMapping(value = "getAllMajors", method = RequestMethod.GET)
    public Result getAllMajors(String problemId) {
        List<Major> majors = majorService.getAllMajors(problemId);
        if (majors == null) {
            return Result.fail();
        }
        return Result.suc(majors);
    }

    @ApiOperation("添加若干个老师")
    @RoleLevel("ADMIN")
    @RequestMapping(value = "addTeachers", method = RequestMethod.POST, produces = "application/json")
    public Result addTeachers(@RequestBody TeacherList teacherList) {
        if (!teacherService.addTeachers(teacherList.getTeacherList())) {
            return Result.fail();
        }
        return Result.suc("添加老师成功");
    }

    @ApiOperation("获得所有老师")
    @RoleLevel("ADMIN")
    @RequestMapping(value = "getAllTeachers", method = RequestMethod.GET)
    public Result getAllTeachers(String problemId) {
        List<Teacher> teachers = teacherService.getAllTeachers(problemId);
        if (teachers == null) {
            return Result.fail();
        }
        return Result.suc(teachers);
    }

    @ApiOperation("添加若干个老师能教的课程(约束)")
    @RoleLevel("ADMIN")
    @RequestMapping(value = "addTeacherCanTeachSubjects", method = RequestMethod.POST, produces = "application/json")
    public Result addTeacherCanTeachSubjects(@RequestBody TeacherCanTeachSubjectList teacherCanTeachSubjectList) {
        if (!teacherCanTeachSubjectService.addTeacherCanTeachSubjectList(
                teacherCanTeachSubjectList.getTeacherCanTeachSubjectList())) {
            return Result.fail();
        }
        return Result.suc("添加老师能教的课成功");
    }

    @ApiOperation("获得所有老师能教的课程(约束)")
    @RoleLevel("ADMIN")
    @RequestMapping(value = "getAllTeacherCanTeachSubjects", method = RequestMethod.GET)
    public Result getAllTeacherCanTeachSubjects(String problemId) {
        List<TeacherCanTeachSubject> teacherCanTeachSubjects =
                teacherCanTeachSubjectService.getAllTeacherCanTeachSubject(problemId);
        if (teacherCanTeachSubjects == null) {
            return Result.fail();
        }
        return Result.suc(teacherCanTeachSubjects);
    }

    @ApiOperation("添加若干个培养计划")
    @RoleLevel("ADMIN")
    @RequestMapping(value = "addTrainingPlans", method = RequestMethod.POST, produces = "application/json")
    public Result addTrainingPlans(@RequestBody TrainingPlanList trainingPlanList) {
        if (!trainingPlanService.addTrainingPlans(trainingPlanList.getTrainingPlanList())) {
            return Result.fail();
        }
        return Result.suc("添加培养计划成功");
    }

    @ApiOperation("获得所有培养计划")
    @RoleLevel("ADMIN")
    @RequestMapping(value = "getAllTrainingPlans", method = RequestMethod.GET)
    public Result getAllTrainingPlans(String problemId) {
        List<TrainingPlan> trainingPlans = trainingPlanService.getAllTrainingPlans(problemId);
        if (trainingPlans == null) {
            return Result.fail();
        }
        return Result.suc(trainingPlans);
    }

    @ApiOperation("添加若干个教学科目")
    @RoleLevel("ADMIN")
    @RequestMapping(value = "addSubjects", method = RequestMethod.POST, produces = "application/json")
    public Result addSubjects(SubjectList subjectList) {
        if (!subjectService.addSubjects(subjectList.getSubjectList())) {
            return Result.fail();
        }
        return Result.suc("添加教学科目成功");
    }

    @ApiOperation("获得所有教学科目")
    @RoleLevel("ADMIN")
    @RequestMapping(value = "getAllSubjects", method = RequestMethod.GET)
    public Result getAllSubjects(String problemId) {
        List<Subject> subjects = subjectService.getAllSubjects(problemId);
        if (subjects == null) {
            return Result.fail();
        }
        return Result.suc(subjects);
    }

    @ApiOperation("为每门 subject 对应生成 courses")
    @RoleLevel("ADMIN")
    @RequestMapping(value = "generateCourses", method = RequestMethod.GET)
    public Result generateCourses(String problemId) {
        if (!courseService.generateCourses(problemId)) {
            return Result.fail();
        }
        return Result.suc();
    }

    @ApiOperation("获得所有课程")
    @RoleLevel("ADMIN")
    @RequestMapping(value = "getAllCourses", method = RequestMethod.GET)
    public Result getAllCourses(String problemId) {
        List<Course> courses = courseService.getAllCourses(problemId);
        if (courses == null) {
            return Result.fail();
        }
        return Result.suc(courses);
    }

    @ApiOperation("获得所有课程-班级信息")
    @RoleLevel("ADMIN")
    @RequestMapping(value = "getAllCourseForClazzs", method = RequestMethod.GET)
    public Result getAllCourseForClazzs(String problemId) {
        List<CourseForClazz> courseForClazzes =
                courseForClazzService.getAllCourseForClazzs(problemId);
        if (courseForClazzes == null) {
            return Result.fail();
        }
        return Result.suc(courseForClazzes);
    }

    @ApiOperation("获得所有课时")
    @RoleLevel("ADMIN")
    @RequestMapping(value = "getAllLessons", method = RequestMethod.GET)
    public Result getAllLessons(String problemId) {
        List<Lesson> lessons = lessonService.getAllLessons(problemId);
        if (lessons == null) {
            return Result.fail();
        }
        return Result.suc(lessons);
    }

    @ApiOperation("获得所有问题")
    @RoleLevel("ADMIN")
    @RequestMapping(value = "getAllProblems", method = RequestMethod.GET)
    public Result getAllProblems() {
        List<Problem> problems = problemService.getAllProblems();
        if (problems == null) {
            return Result.fail();
        }
        return Result.suc(problems);
    }

    @ApiOperation("返回所有老师-教-课程")
    @RoleLevel("ADMIN")
    @RequestMapping(value = "getAllTeacherTeachCourse", method = RequestMethod.GET)
    public Result getAllTeacherTeachCourse(String problemId) {
        List<TeacherTeachCourse> teacherTeachCourses =
                teacherTeachCourseService.getAllTeacherTeachCourses(problemId);
        if (teacherTeachCourses == null) {
            return Result.fail();
        }
        return Result.suc(teacherTeachCourses);
    }

    @ApiOperation("开始求解")
    @RoleLevel("ADMIN")
    @RequestMapping(value = "startSolving", method = RequestMethod.GET)
    public Result startSolving(String problemId) {
        Solution problem = solveJobService.generateProblem(problemId);
        if (problem == null)
            return Result.fail();
        solveJobService.addSolveJob(problemId, problem);
        return Result.suc();
    }

    @ApiOperation("要求停止一个求解任务")
    @RoleLevel("ADMIN")
    @RequestMapping(value = "stopSolving", method = RequestMethod.GET)
    public Result stopSolving(String problemId) {
        solveJobService.stopSolving(problemId);
        return Result.suc();
    }

    @ApiOperation("查询一个求解任务的状态")
    @RoleLevel("ADMIN")
    @RequestMapping(value = "querySolveStatus", method = RequestMethod.GET)
    public Result querySolveStatus(String problemId) {
        Solution.Status status = solveJobService.querySolveJobStatus(problemId);
        if (status == null)
            return Result.fail();
        return Result.suc(status);
    }


    @ApiOperation("设置一次求解最长时间")
    @RoleLevel("设置一次求解最长时间")
    @RequestMapping(value = "setWaitSecs", method = RequestMethod.GET)
    public Result setWaitSecs(int waitSecs) {
        solveJobService.setWaitSecs(waitSecs);
        return Result.suc();
    }

    ///////////// 查询

    @ApiOperation("查询一个学生要上的所有 Lessons")
    @RequestMapping(value = "getLessonsByStudentId", method = RequestMethod.GET)
    public Result getLessonsByStudentId(String problemId, Integer studentId) {
        List<Lesson> lessons = lessonService.getLessonsByStudentId(problemId, studentId);
        if (lessons == null) {
            return Result.fail();
        }
        return Result.suc(lessons);
    }
}
