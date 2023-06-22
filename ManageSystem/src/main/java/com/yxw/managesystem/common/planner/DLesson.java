package com.yxw.managesystem.common.planner;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DLesson dLesson = (DLesson) o;
        return getId().equals(dLesson.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
