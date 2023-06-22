package com.yxw.managesystem.common.planner;

import lombok.Getter;
import lombok.Setter;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@PlanningEntity
public class DCourse {

    private Integer id;

    /**
     * 这门课对应的 subject
     */
    private DSubject dSubject;

    /**
     * 这门课的教师
     */
    @PlanningVariable
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
     * 这门课是为了哪些教学班开的
     */
    private List<DClazz> forClazz;

    /**
     * 判断某一周是否有这门课
     */
    public boolean isOpen(DWeek week) {
        if (week == null || this.dWeek == null)
            return false;
        return week.getIndex() >= dWeek.getIndex()
                && week.getIndex() < dWeek.getIndex() + weeks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DCourse dCourse = (DCourse) o;
        return getId().equals(dCourse.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
