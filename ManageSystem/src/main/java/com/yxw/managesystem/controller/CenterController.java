package com.yxw.managesystem.controller;

import com.yxw.managesystem.common.Result;
import com.yxw.managesystem.dto.MajorList;
import com.yxw.managesystem.dto.StudentList;
import com.yxw.managesystem.dto.TeacherList;
import com.yxw.managesystem.service.IStudentService;
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

    @RequestMapping(value = "addStudents", method = RequestMethod.POST, produces = "application/json")
    public Result<?> addStudents(@RequestBody StudentList studentList) {
        if (!studentService.addStudents(studentList.getStudentList())) {
            return Result.fail();
        }
        return Result.suc("添加学生成功");
    }

//    @RequestMapping(value = "addStudents", method = RequestMethod.POST, produces = "application/json")
//    public Result<?> addMajors(@RequestBody MajorList majorList) {
//
//        return Result.suc("添加专业成功");
//    }
//
//    @RequestMapping(value = "addTeachers", method = RequestMethod.POST, produces = "application/json")
//    public Result<?> addTeachers(@RequestBody TeacherList teacherList) {
//
//        return Result.suc("添加老师成功");
//    }

    @ApiOperation("开始求解")
    @RequestMapping("startSolving")
    public Result<String> startSolving() {
        throw new UnsupportedOperationException();
    }

    @ApiOperation("要求停止一个求解任务")
    @RequestMapping("stopSolving")
    public Result<?> stopSolving(String uuid) {
        throw new UnsupportedOperationException();
    }

    @ApiOperation("查询一个求解任务的状态")
    public Result<?> querySolveStatus(String uuid) {
        throw new UnsupportedOperationException();
    }
}
