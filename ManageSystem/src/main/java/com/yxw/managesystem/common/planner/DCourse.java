package com.yxw.managesystem.common.planner;

import lombok.Getter;
import lombok.Setter;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import java.util.List;

@Getter
@Setter
@PlanningEntity
public class DCourse {

    private Integer id;

    /**
     * 这门课的教师
     */
//    @PlanningVariable
    private DTeacher dTeacher;

    /**
     * 这门课从第几周开始上
     */
    @PlanningVariable
    private DWeek dWeek;

    /**
     * 这门课要上几周
     */
    private int weeks;

    /**
     * 这门课的所有课时
     */
    private List<DLesson> lessons;

    /**
     * 判断某一周是否有这门课
     */
    public boolean isOpen(DWeek week) {
        if (week == null || this.dWeek == null)
            return false;
        return week.getIndex() >= dWeek.getIndex()
                && week.getIndex() < dWeek.getIndex() + weeks;
    }
}
