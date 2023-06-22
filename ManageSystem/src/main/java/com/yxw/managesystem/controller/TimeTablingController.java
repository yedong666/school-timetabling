package com.yxw.managesystem.controller;


import com.yxw.managesystem.common.Result;
import com.yxw.managesystem.service.impl.TimeTablingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *排课控制器
 */
@RestController
@RequestMapping("/timeTabling")
public class TimeTablingController {
    @Autowired
    private TimeTablingServiceImpl timeTablingService;
    /**
     * 自动排课
     * 根据现有教室、教师、课程计划进行排课
     * @return
     */
    @GetMapping("/scheduleLessons")
    public Result<Boolean> scheduleLessons(){
        timeTablingService.scheduleLessons();
        return Result.suc(true);
    }

    /**
     * 管理员手动排课
     */
    @PostMapping("/scheduleLessons")
    public Result<Boolean> scheduleLessonsByAdmin(){
        return Result.suc(true);
    }
}
