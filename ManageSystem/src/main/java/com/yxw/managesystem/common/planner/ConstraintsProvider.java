package com.yxw.managesystem.common.planner;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;

import static org.optaplanner.core.api.score.stream.ConstraintCollectors.toList;

public class ConstraintsProvider implements ConstraintProvider {
    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[] {
            roomConflictConstraint(constraintFactory)
        };
    }

    private Constraint roomConflictConstraint(ConstraintFactory cf) {
        return cf.forEach(DLesson.class).join(DWeek.class)
                .filter((l, w) -> l.getDCourse().isOpen(w))
                .groupBy((l, w) -> w.getIndex(), toList((l, w) -> l))
                .map((wi, ls) -> { // 第 wi 周的所有课
                    int conflictCnt = 0;
                    for (int i = 0; i < ls.size(); i ++) {
                        DLesson li = ls.get(i);
                        if (li.getDTimeSlot() == null || li.getDClassroom() == null)
                            continue;
                        for (int j = i + 1; j < ls.size(); j ++) {
                            DLesson lj = ls.get(j);
                            if (lj.getDTimeSlot() == null || lj.getDClassroom() == null)
                                continue;
                            // 同一周，同一时间的两节课占用同一间教室，认为冲突！
                            if (li.getDTimeSlot().equals(lj.getDTimeSlot()) && li.getDClassroom().equals(lj.getDClassroom()))
                                conflictCnt ++;
                        }
                    }
                    return conflictCnt;
                })
                .penalize(HardSoftScore.ONE_HARD, i -> i)
                .asConstraint("Room Conflict Constraint");
    }
}
