package com.yxw.managesystem.controller;

import com.yxw.managesystem.common.Result;
import com.yxw.managesystem.common.planner.Solution;
import com.yxw.managesystem.dto.*;
import com.yxw.managesystem.service.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    private ISolveJobService solveJobService;

    @RequestMapping(value = "addStudents", method = RequestMethod.POST, produces = "application/json")
    public Result<?> addStudents(@RequestBody StudentList studentList) {
        if (!studentService.addStudents(studentList.getStudentList())) {
            return Result.fail();
        }
        return Result.suc("添加学生成功");
    }

    @RequestMapping(value = "addClassrooms", method = RequestMethod.POST, produces = "application/json")
    public Result<?> addClassrooms(@RequestBody ClassroomList classroomList) {
        if (!classroomService.addClassrooms(classroomList.getClassroomList())) {
            return Result.fail();
        }
        return Result.suc("添加教室成功");
    }

    @RequestMapping(value = "addMajors", method = RequestMethod.POST, produces = "application/json")
    public Result<?> addMajors(@RequestBody MajorList majorList) {
        if (!majorService.addMajors(majorList.getMajorList())) {
            return Result.fail();
        }
        return Result.suc("添加专业成功");
    }

    @RequestMapping(value = "addTeachers", method = RequestMethod.POST, produces = "application/json")
    public Result<?> addTeachers(@RequestBody TeacherList teacherList) {
        if (!teacherService.addTeachers(teacherList.getTeacherList())) {
            return Result.fail();
        }
        return Result.suc("添加老师成功");
    }

    @RequestMapping(value = "addTeacherCanTeachSubject", method = RequestMethod.POST, produces = "application/json")
    public Result<?> addTeacherCanTeachSubject(@RequestBody TeacherCanTeachSubjectList teacherCanTeachSubjectList) {
        if (!teacherCanTeachSubjectService.addTeacherCanTeachSubjectList(
                teacherCanTeachSubjectList.getTeacherCanTeachSubjectList())) {
            return Result.fail();
        }
        return Result.suc("添加老师能教的课成功");
    }

    @RequestMapping(value = "addTrainingPlan", method = RequestMethod.POST, produces = "application/json")
    public Result<?> addTrainingPlan(@RequestBody TrainingPlanList trainingPlanList) {
        if (!trainingPlanService.addTrainingPlans(trainingPlanList.getTrainingPlanList())) {
            return Result.fail();
        }
        return Result.suc("添加培养计划成功");
    }

    @ApiOperation("开始求解")
    @RequestMapping("startSolving")
    public Result<?> startSolving(String problemId) {
        Solution problem = solveJobService.generateProblem(problemId);
        if (problem == null)
            return Result.fail();
        solveJobService.addSolveJob(problemId, problem);
        return Result.suc();
    }

    @ApiOperation("要求停止一个求解任务")
    @RequestMapping("stopSolving")
    public Result<?> stopSolving(String problemId) {
        solveJobService.stopSolving(problemId);
        return Result.suc();
    }

    @ApiOperation("查询一个求解任务的状态")
    public Result<?> querySolveStatus(String problemId) {
        Solution.Status status = solveJobService.querySolveJobStatus(problemId);
        if (status == null)
            return Result.fail();
        return Result.suc(status);
    }
}
