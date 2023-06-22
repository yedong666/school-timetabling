package com.yxw.managesystem.common.planner;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class DSubject {

    private Integer id;

    /**
     * 对应开设课程最大选课人数
     */
    private Integer subjectStuCapacity;

    /**
     * 这门课需要上多少学时
     */
    private Integer subjectLessonNum;

    /**
     * 这门课每周需要上几节课（多少学时）
     */
    private Integer subjectLessonPerWeek;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DSubject dSubject = (DSubject) o;
        return getId().equals(dSubject.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
