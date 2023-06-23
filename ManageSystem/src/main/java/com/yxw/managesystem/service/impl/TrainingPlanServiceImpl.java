package com.yxw.managesystem.service.impl;

import com.yxw.managesystem.entity.TeacherCanTeachSubject;
import com.yxw.managesystem.entity.TrainingPlan;
import com.yxw.managesystem.mapper.TrainingPlanMapper;
import com.yxw.managesystem.service.ITrainingPlanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 培养计划表 服务实现类
 * </p>
 *
 * @author yyd
 * @since 2023-06-14
 */
@Service
public class TrainingPlanServiceImpl extends ServiceImpl<TrainingPlanMapper, TrainingPlan> implements ITrainingPlanService {

    @Autowired
    private TrainingPlanMapper trainingPlanMapper;

    @Override
    public boolean addTrainingPlans(List<TrainingPlan> trainingPlanList) {
        try {
            for (TrainingPlan trainingPlan : trainingPlanList) {
                trainingPlanMapper.insert(trainingPlan);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
