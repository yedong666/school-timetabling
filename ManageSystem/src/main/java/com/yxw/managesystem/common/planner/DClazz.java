package com.yxw.managesystem.common.planner;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * 一个教学班
 */
@Getter
@Setter
public class DClazz {
    private Integer id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DClazz dClazz = (DClazz) o;
        return id.equals(dClazz.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
