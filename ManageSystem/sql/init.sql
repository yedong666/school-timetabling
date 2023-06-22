use manage_system;

drop table if exists manage_system.problem;
CREATE TABLE problem
(
    problem_id INT NOT NULL AUTO_INCREMENT COMMENT '问题id',
    problem_uuid varchar(36) NOT NULL COMMENT '问题uuid',
    system_user_id INT NOT NULL COMMENT '发起排课的用户id',
    create_time DATETIME NOT NULL COMMENT '发起时间',
    PRIMARY KEY (`problem_id`)
)ENGINE = InnoDB
DEFAULT CHARSET = utf8 COMMENT ='问题表';

drop table if exists manage_system.student;
CREATE TABLE student
(
    student_id INT NOT NULL AUTO_INCREMENT COMMENT '学生id',
    student_name  varchar(20) NOT NULL COMMENT '用户名',
    student_enter_time DATETIME NOT NULL COMMENT '入学时间',
    student_year_no tinyint DEFAULT 1 COMMENT '第几学期',
    clazz_id INT COMMENT '学生班级',
    major_id INT NOT NULL COMMENT '专业id',
    problem_id INT NOT NULL COMMENT '问题id',
    PRIMARY KEY (`student_id`)
)ENGINE = InnoDB
 DEFAULT CHARSET = utf8 COMMENT ='学生表';

drop table if exists manage_system.clazz;
CREATE TABLE clazz
(
    clazz_id INT NOT NULL AUTO_INCREMENT COMMENT '教学班id',
    clazz_name varchar(40) NOT NULL COMMENT '教学班名',
    problem_id INT NOT NULL COMMENT '问题id',
    PRIMARY KEY (`clazz_id`)
)ENGINE = InnoDB
DEFAULT CHAR SET = utf8 COMMENT = '教学班表';

drop table if exists manage_system.major;
CREATE TABLE major(
      major_id  INT NOT NULL AUTO_INCREMENT COMMENT '主键',
      major_name varchar(20) NOT NULL COMMENT '专业名',
      problem_id INT NOT NULL COMMENT '问题id',
      PRIMARY KEY (`major_id`)
)ENGINE = InnoDB
 DEFAULT CHARSET = utf8 COMMENT ='培养计划表';

drop table if exists manage_system.training_plan;
CREATE TABLE training_plan(
          training_plan_id  INT NOT NULL AUTO_INCREMENT COMMENT '主键',
          major_id INT  NOT NULL COMMENT '专业id',
          year_no TINYINT NOT NULL COMMENT '第几学期',
          subject_id INT NOT NULL ,
          problem_id INT NOT NULL COMMENT '问题id',
          PRIMARY KEY (`training_plan_id`)
)ENGINE = InnoDB
 DEFAULT CHARSET = utf8 COMMENT ='培养计划表';

drop table if exists manage_system.subject;
CREATE TABLE subject
(
    subject_id   INT NOT NULL AUTO_INCREMENT COMMENT '科目(学科)id',
    subject_name varchar(50)                NOT NULL,
    subject_desc varchar(200)                NOT NULL,
    subject_stu_capacity INT DEFAULT 50 COMMENT '对应开设课程最大选课人数',
    subject_type TINYINT DEFAULT 1 COMMENT '1: 公共基础课 2:',
    subject_lesson_num INT DEFAULT 30 COMMENT '这门课需要上多少学时',
    subject_lesson_per_week INT DEFAULT 3 COMMENT '这门课每周需要上几节课（多少学时）',
    problem_id INT NOT NULL COMMENT '问题id',
    PRIMARY KEY (`subject_id`)
)ENGINE = InnoDB
 DEFAULT CHARSET = utf8 COMMENT ='教学科目表';

drop table if exists manage_system.teacher;
CREATE TABLE teacher
(
    teacher_id   INT NOT NULL AUTO_INCREMENT COMMENT '教师id',
    teacher_name varchar(20) NOT NULL,
    problem_id INT NOT NULL COMMENT '问题id',
    PRIMARY KEY (`teacher_id`)
)ENGINE = InnoDB
 DEFAULT CHARSET = utf8 COMMENT = '教师表';


drop table if exists manage_system.teacher_can_teach_subject;
CREATE TABLE teacher_can_teach_subject
(
    teacher_can_teach_subject_id INT NOT NULL AUTO_INCREMENT COMMENT '主键',
    teacher_id INT NOT NULL,
    subject_id INT NOT NULL,
    problem_id INT NOT NULL COMMENT '问题id',
    PRIMARY KEY (`teacher_can_teach_subject_id`)
)ENGINE = InnoDB
 DEFAULT CHARSET = utf8 COMMENT = '教师与教学科目关联表(多对多关系)';

drop table if exists manage_system.course;
CREATE TABLE course
(
    course_id  INT NOT NULL AUTO_INCREMENT COMMENT '课程id',
    course_name varchar(50) NOT NULL COMMENT '课程名',
    subject_id INT NOT NULL,
    from_week INT COMMENT '从第几周开始上 in',
    to_week INT COMMENT '上到第几周 ex',
    problem_id INT NOT NULL COMMENT '问题id',
    PRIMARY KEY (`course_id`)
)ENGINE = InnoDB
 DEFAULT CHARSET = utf8 COMMENT = '课程表(与教学科目表为一对多关系)';

drop table if exists manage_system.course_for_class;
CREATE TABLE course_for_clazz
(
    course_for_class_id INT NOT NULL AUTO_INCREMENT COMMENT '课程为教学班开设, 一条记录的 id',
    course_id INT NOT NULL COMMENT '课程id',
    clazz_id INT NOT NULL COMMENT '教学班id',
    problem_id INT NOT NULL COMMENT '问题id',
    PRIMARY KEY (`course_for_class_id`)
)ENGINE = InnoDB
 DEFAULT CHARSET = utf8 COMMENT = '课程与教学班关联表, 记录一门课主要为哪些教学班开设';

drop table if exists manage_system.teacher_teach_course;
CREATE TABLE teacher_teach_course
(
    teacher_teach_course_id INT NOT NULL AUTO_INCREMENT COMMENT '主键',
    teacher_id              INT             NOT NULL,
    course_id               INT             NOT NULL,
    problem_id INT NOT NULL COMMENT '问题id',
    PRIMARY KEY (`teacher_teach_course_id`)
)ENGINE = InnoDB
 DEFAULT CHARSET = utf8 COMMENT = '教师与课程关系(一对多关系)';

drop table if exists manage_system.student_select_course;
CREATE TABLE student_select_course
(
    student_select_course_id INT NOT NULL AUTO_INCREMENT COMMENT '主键',
    student_id               INT             NOT NULL,
    course_id                INT             NOT NULL,
    problem_id INT NOT NULL COMMENT '问题id',
    PRIMARY KEY (`student_select_course_id`)
)ENGINE = InnoDB
 DEFAULT CHARSET = utf8 COMMENT = '学生与课程关系(多对多关系)';
# 是否与student_should_select_subject表功能重合?


drop table if exists manage_system.lesson;
CREATE TABLE lesson
(
    lesson_id    INT NOT NULL AUTO_INCREMENT COMMENT '课时id',
    course_id    INT             NOT NULL,
    timeslot_id  INT,
    classroom_id INT,
    problem_id INT NOT NULL COMMENT '问题id',
    PRIMARY KEY (`lesson_id`)
)ENGINE = InnoDB
 DEFAULT CHARSET = utf8 COMMENT = '课程的课时安排表';

drop table if exists manage_system.classroom;
CREATE TABLE classroom
(
    classroom_id   INT NOT NULL AUTO_INCREMENT COMMENT '主键',
    classroom_desc varchar(50)                NOT NULL,
    classroom_capacity INT DEFAULT 50 COMMENT '教室容量', # 感觉应当有一个容量
    problem_id INT NOT NULL COMMENT '问题id',
    # 在哪一栋楼？ 在哪一层？ 即具体的位置信息需要吗？ 还是说包含在desc里
    PRIMARY KEY (`classroom_id`)
)ENGINE = InnoDB
 DEFAULT CHARSET = utf8 COMMENT = '教室信息表';