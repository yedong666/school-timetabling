package com.yxw.managesystem.common.planner;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;
import org.optaplanner.core.api.score.stream.Joiners;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.optaplanner.core.api.score.stream.ConstraintCollectors.toList;

public class ConstraintsProvider implements ConstraintProvider {
    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[] {
            roomConflictConstraint(constraintFactory),
            teacherTimeConstraint(constraintFactory),
            clazzTimeConstraint(constraintFactory),
            roomCapacityConstraint(constraintFactory),
        };
    }

    /**
     * 约束：同一时刻同一间教室只能上一节课
     */
    private Constraint roomConflictConstraint(ConstraintFactory cf) {
        return cf.forEach(DLesson.class)
                .join(DLesson.class,
                        Joiners.equal(DLesson::getDTimeSlot), // 一周中同一时间
                        Joiners.equal(DLesson::getDClassroom), //  同一老师
                        Joiners.greaterThan(DLesson::getId)) // 保证唯一
                .join(DWeek.class,
                        Joiners.filtering((l1, l2, w) -> { // 这一周两门课都要开课
                            DCourse l1c = l1.getDCourse();
                            DCourse l2c = l2.getDCourse();
                            return l1c.isOpen(w) && l2c.isOpen(w);
                        }))
                .penalize(HardSoftScore.ONE_HARD)
                .asConstraint("Room Conflict Constraint");
    }

    /**
     * 约束：老师只能教他能教的课
     */
    private Constraint teacherAvailableConstraint(ConstraintFactory cf) {
        return cf.forEach(DCourse.class)
                .filter(c -> {
                    DSubject subject = c.getDSubject();
                    DTeacher teacher = c.getDTeacher();
                    if (teacher == null)
                        return true;
                    return !teacher.getAvailableSubjects().contains(subject);
                })
                .penalize(HardSoftScore.ONE_HARD)
                .asConstraint("Teacher Available Constraint");
    }

    /**
     * 约束：同一时间一个老师只能教一门课
     */
    private Constraint teacherTimeConstraint(ConstraintFactory cf) {
        return cf.forEach(DLesson.class)
                .join(DLesson.class,
                        Joiners.equal(DLesson::getDTimeSlot), // 一周中同一时间
                        Joiners.equal(l -> l.getDCourse().getDTeacher()), // 同一老师
                        Joiners.greaterThan(DLesson::getId)) // 保证唯一
                .join(DWeek.class,
                        Joiners.filtering((l1, l2, w) -> { // 这一周两门课都要开课
                            DCourse l1c = l1.getDCourse();
                            DCourse l2c = l2.getDCourse();
                            return l1c.isOpen(w) && l2c.isOpen(w);
                        }))
                .penalize(HardSoftScore.ONE_HARD)
                .asConstraint("Teacher Available Constraint");
    }

    /**
     * 一个班级 (的所有学生) 同一时间只能上一节课
     */
    private Constraint clazzTimeConstraint(ConstraintFactory cf) {
        return cf.forEach(DLesson.class)
                .join(DLesson.class,
                        Joiners.equal(DLesson::getDTimeSlot), // 一周中同一时间
                        Joiners.greaterThan(DLesson::getId), // 保证唯一
                        Joiners.filtering((l1, l2) -> { // 两门课的目标班级重叠
                            List<DClazz> forClazz1 = l1.getDCourse().getForClazz();
                            List<DClazz> forClazz2 = l2.getDCourse().getForClazz();
                            return !Collections.disjoint(forClazz1, forClazz2);
                        }))
                .join(DWeek.class,
                        Joiners.filtering((l1, l2, w) -> { // 这一周两门课都要开课
                            DCourse l1c = l1.getDCourse();
                            DCourse l2c = l2.getDCourse();
                            return l1c.isOpen(w) && l2c.isOpen(w);
                        }))
                .penalize(HardSoftScore.ONE_HARD)
                .asConstraint("Clazz Time Constraint");
    }

    /**
     * 每节课上课的学生数不能超过教室容量
     */
    private Constraint roomCapacityConstraint(ConstraintFactory cf) {
        return cf.forEach(DLesson.class)
                .filter(l -> {
                    DCourse dCourse = l.getDCourse();
                    DClassroom dClassroom = l.getDClassroom();
                    DSubject dSubject = dCourse.getDSubject();
                    int stuNum = dSubject.getSubjectStuCapacity();
                    int roomCapacity = dClassroom.getCapacity();
                    return stuNum > roomCapacity;
                })
                .penalize(HardSoftScore.ONE_HARD)
                .asConstraint("Room Capacity Constraint");
    }
}
