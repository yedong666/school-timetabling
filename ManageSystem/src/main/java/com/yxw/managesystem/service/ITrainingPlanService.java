package com.yxw.managesystem.service;

import com.yxw.managesystem.entity.TrainingPlan;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.annotation.Nullable;
import java.util.List;

/**
 * <p>
 * 培养计划表 服务类
 * </p>
 *
 * @author yyd
 * @since 2023-06-14
 */
public interface ITrainingPlanService extends IService<TrainingPlan> {

    boolean addTrainingPlans(List<TrainingPlan> trainingPlanList);

    @Nullable
    List<TrainingPlan> getAllTrainingPlans(String problemId);
}
