use manage_system;

drop table if exists manage_system.student;
CREATE TABLE student
(
    student_id INT NOT NULL AUTO_INCREMENT COMMENT '学生id',
    student_name  varchar(20) NOT NULL COMMENT '用户名',
    student_grade INT NOT NULL COMMENT '学生年级',
    student_class INT NOT NULL COMMENT '学生班级', #班级的作用?
    PRIMARY KEY (`student_id`)
)ENGINE = InnoDB
 DEFAULT CHARSET = utf8 COMMENT ='学生表';

drop table if exists manage_system.subject;
CREATE TABLE subject
(
    subject_id   INT NOT NULL AUTO_INCREMENT COMMENT '科目(学科)id',
    subject_name varchar(50)                NOT NULL,
    subject_desc varchar(200)                NOT NULL,
    PRIMARY KEY (`subject_id`)
)ENGINE = InnoDB
 DEFAULT CHARSET = utf8 COMMENT ='教学科目表';

drop table if exists manage_system.teacher;
CREATE TABLE teacher
(
    teacher_id   INT NOT NULL AUTO_INCREMENT COMMENT '教师id',
    teacher_name varchar(20)                NOT NULL,
    PRIMARY KEY (`teacher_id`)
)ENGINE = InnoDB
 DEFAULT CHARSET = utf8 COMMENT = '教师表';


drop table if exists manage_system.teacher_can_teach_subject;
CREATE TABLE teacher_can_teach_subject
(
    teacher_can_teach_subject_id INT NOT NULL AUTO_INCREMENT COMMENT '主键',
    teacher_id                   INT             NOT NULL,
    subject_id                   INT             NOT NULL,
    PRIMARY KEY (`teacher_can_teach_subject_id`)
)ENGINE = InnoDB
 DEFAULT CHARSET = utf8 COMMENT = '教师与教学科目关联表(多对多关系)';

drop table if exists manage_system.student_should_select_subject;
CREATE TABLE student_should_select_subject
(
    student_should_select_subject_id INT NOT NULL AUTO_INCREMENT COMMENT '主键',
    student_id                       INT             NOT NULL,
    subject_id                       INT             NOT NULL,
    PRIMARY KEY (`student_should_select_subject_id`)
)ENGINE = InnoDB
 DEFAULT CHARSET = utf8 COMMENT = '学生与教学科目关联表(多对多关系)';

drop table if exists manage_system.course;
CREATE TABLE course
(
    course_id  INT NOT NULL AUTO_INCREMENT COMMENT '课程id',
    subject_id INT             NOT NULL,
    PRIMARY KEY (`course_id`)
)ENGINE = InnoDB
 DEFAULT CHARSET = utf8 COMMENT = '课程表(与教学科目表为一对多关系)';

drop table if exists manage_system.teacher_teach_course;
CREATE TABLE teacher_teach_course
(
    teacher_teach_course_id INT NOT NULL AUTO_INCREMENT COMMENT '主键',
    teacher_id              INT             NOT NULL,
    course_id               INT             NOT NULL,
    PRIMARY KEY (`teacher_teach_course_id`)
)ENGINE = InnoDB
 DEFAULT CHARSET = utf8 COMMENT = '教师与课程关系(一对多关系)';

drop table if exists manage_system.student_select_course;
CREATE TABLE student_select_course
(
    student_select_course_id INT NOT NULL AUTO_INCREMENT COMMENT '主键',
    student_id               INT             NOT NULL,
    course_id                INT             NOT NULL,
    PRIMARY KEY (`student_select_course_id`)
)ENGINE = InnoDB
 DEFAULT CHARSET = utf8 COMMENT = '学生与课程关系(多对多关系)';
# 是否与student_should_select_subject表功能重合?


drop table if exists manage_system.lesson;
CREATE TABLE lesson
(
    lesson_id    INT NOT NULL AUTO_INCREMENT COMMENT '课时id',
    course_id    INT             NOT NULL,
    teacher_id   INT DEFAULT 0,
    timeslot_id  INT DEFAULT 0,
    classroom_id INT DEFAULT 0,
    is_set tinyint(2) DEFAULT 0 COMMENT '是否已安排完毕(需要吗？)',
    PRIMARY KEY (`lesson_id`)
)ENGINE = InnoDB
 DEFAULT CHARSET = utf8 COMMENT = '课程的课时安排表';

# 我的理解: 一个科目(学科)下有多个课程，每个课程有多个课时,
# 同一科目下的课程主要是授课老师不同，同一课程下的课时主要是时间安排和教室安排不同
# 举例： 有一门科目A, 开设了4门课由4个不同老师负责{a1:t1, a2:t2, a3:t3, a4:t4}
# 若老师t1负责的a1课, 则其又对应一组时间安排和教室安排{{time1, room1}, {time2, room2} ...}
# 同时得满足以下约束：
# t1负责的科目集必须包含A;
# 求翔神补充，感觉各种约束挺多的


# 感觉此表不需要
# 假设某个学生stu需要查询某一个在timeslot的课是什么, 可通过以下查询实现:
# select lesson_id from lesson where timeslot_id = timeslot
# and course_id in (select course_id from student_select_course where student_id = stu);
# 同时我感觉应当给表添加一些常用的字段，而不是通过关联查询来获取
# 比如我想知道某个lesson的名字，我得先关联到course, 再关联到subject才能获取到lesson的名字, 效率相对而言较低, sql复杂度也增高了
# 何不如添加一个lesson_name的字段以及course_name的字段
# CREATE TABLE student_take_lesson
# (
#     student_take_lesson_id INT NOT NULL AUTO_INCREMENT COMMENT '主键',
#     student_id             INT             NOT NULL,
#     lesson_id              INT             NOT NULL,
#     PRIMARY KEY (`student_take_lesson_id`)
# )ENGINE = InnoDB
#  DEFAULT CHARSET = utf8 COMMENT = '学生与课时关联表';

drop table if exists manage_system.classroom;
CREATE TABLE classroom
(
    classroom_id   INT NOT NULL AUTO_INCREMENT COMMENT '主键',
    classroom_desc varchar(50)                NOT NULL,
    classroom_capacity INT DEFAULT 50 COMMENT '教室容量', # 感觉应当有一个容量
    # 在哪一栋楼？ 在哪一层？ 即具体的位置信息需要吗？ 还是说包含在desc里
    PRIMARY KEY (`classroom_id`)
)ENGINE = InnoDB
 DEFAULT CHARSET = utf8 COMMENT = '教室信息表';

# 关于时间段这个表的设计我的想法是这样的
drop table if exists manage_system.timeslot;
CREATE TABLE timeslot
(
    timeslot_id INT NOT NULL AUTO_INCREMENT COMMENT '主键',
    from_time   varchar(50)                NOT NULL,
    to_time     varchar(50)                NOT NULL,
    PRIMARY KEY (`timeslot_id`)
)ENGINE = InnoDB
 DEFAULT CHARSET = utf8 COMMENT = '课时时间表';