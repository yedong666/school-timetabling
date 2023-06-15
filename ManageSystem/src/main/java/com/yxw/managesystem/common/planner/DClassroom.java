package com.yxw.managesystem.common.planner;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class DClassroom {

    private Integer id;

    /**
     * 教室容量
     */
    private int capacity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DClassroom dClassroom = (DClassroom) o;
        return getId().equals(dClassroom.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
