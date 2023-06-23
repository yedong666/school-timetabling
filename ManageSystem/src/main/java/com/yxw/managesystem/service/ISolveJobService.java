package com.yxw.managesystem.service;

import com.yxw.managesystem.common.planner.Solution;

import java.util.UUID;

public interface ISolveJobService {

    /**
     * 根据当前表中的数据生成求解任务
     */
    Solution generateProblem(String problemId);

    /**
     * 添加一个求解任务
     */
    void addSolveJob(String problemId, Solution problem);

    /**
     * 查询一个求解任务的状态
     */
    Solution.Status querySolveJobStatus(String problemId);

    /**
     * 停止一个求解任务
     */
    void stopSolving(String problemId);
}
