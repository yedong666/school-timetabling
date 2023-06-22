package com.yxw.managesystem.common.planner;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
public class DTeacher {

    private Integer id;

    /**
     * 这个老师能教的 subject
     */
    private Set<DSubject> availableSubjects;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DTeacher dTeacher = (DTeacher) o;
        return getId().equals(dTeacher.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
