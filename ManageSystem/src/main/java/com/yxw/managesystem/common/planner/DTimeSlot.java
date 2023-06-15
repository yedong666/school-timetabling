package com.yxw.managesystem.common.planner;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class DTimeSlot {

    private int index;

    /**
     * 这个 time slot 在一周中的第几天
     */
    public int nthDay() {
        return index / 4;
    }

    /**
     * 这个 time slot 在一天中的第几节课
     */
    public int nthClass() {
        return index % 4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DTimeSlot dTimeSlot = (DTimeSlot) o;
        return getIndex() == dTimeSlot.getIndex();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIndex());
    }
}
