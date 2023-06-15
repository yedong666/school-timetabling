package com.yxw.managesystem.common.planner;

import lombok.Getter;
import lombok.Setter;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@Getter
@Setter
@PlanningEntity
public class DLesson {

    private Integer id;

    /**
     * 这堂课上的什么课
     */
    private DCourse dCourse;

    /**
     * 这堂课的地点
     */
    @PlanningVariable
    private DClassroom dClassroom;

    /**
     * 这堂课在一周中所处的时间段
     */
    @PlanningVariable
    private DTimeSlot dTimeSlot;
}
