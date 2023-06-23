package com.yxw.managesystem.dto;

import com.yxw.managesystem.entity.TrainingPlan;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TrainingPlanList implements Serializable {

    private List<TrainingPlan> trainingPlanList;
}
