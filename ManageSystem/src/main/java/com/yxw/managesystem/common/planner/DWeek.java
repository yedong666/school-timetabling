package com.yxw.managesystem.common.planner;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
@Setter
public class DWeek {

    private int index;

    public static List<DWeek> range(int fromIn, int toEx) {
        return IntStream.range(fromIn, toEx).mapToObj(i -> {
                    DWeek week = new DWeek();
                    week.setIndex(i);
                    return week;
                }).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DWeek dWeek = (DWeek) o;
        return getIndex() == dWeek.getIndex();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIndex());
    }
}
