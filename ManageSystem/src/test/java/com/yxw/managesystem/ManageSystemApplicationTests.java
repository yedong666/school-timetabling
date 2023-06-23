package com.yxw.managesystem;

import com.yxw.managesystem.common.planner.DCourse;
import com.yxw.managesystem.common.planner.DLesson;
import com.yxw.managesystem.common.planner.Solution;
import com.yxw.managesystem.entity.*;
import com.yxw.managesystem.mapper.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class ManageSystemApplicationTests {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private MajorMapper majorMapper;

    @Autowired
    private SubjectMapper subjectMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private TrainingPlanMapper trainingPlanMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private TeacherCanTeachSubjectMapper teacherCanTeachSubjectMapper;

    @Autowired
    private ClassroomMapper classroomMapper;

    @Autowired
    private ClazzMapper clazzMapper;

    @Autowired
    private CourseForClazzMapper courseForClazzMapper;

    @Autowired
    private LessonMapper lessonMapper;

    @Autowired
    private TeacherTeachCourseMapper teacherTeachCourseMapper;

    private static final String problemId = "c90db1a9-6c02-48b3-9738-af33dac56f29";

    @Test
    void emptyAllTables() {
        classroomMapper.empty();
        clazzMapper.empty();
        courseMapper.empty();
        courseForClazzMapper.empty();
        lessonMapper.empty();
        majorMapper.empty();

    }

    @Test
    void generateStudentsAndClazz() {
        // 生成学生数据
        int[] majorSizeArr = new int[]{ 150, 100, 50 };
        int classSize = 50; // 一个班的人数
        int stuCnt = 1;
        int clazzCnt = 1;
        for (int i = 1; i <= majorSizeArr.length; i ++) {
            int majorSize = majorSizeArr[i - 1];
            int classNum = majorSize % classSize == 0
                    ? majorSize / classSize
                    : majorSize / classSize + 1;
            for (int j = 1; j <= classNum; j ++) {
                for (int k = 0; k < classSize; k ++) {
                    Student student = new Student();
                    student.setProblemId(problemId);
                    student.setStudentId(stuCnt);
                    student.setStudentName("学生" + stuCnt ++);
                    student.setClazzId(clazzCnt);
                    student.setMajorId(i);
                    student.setStudentEnterTime(LocalDateTime.of(2023, Month.SEPTEMBER, 3, 0, 0));
                    student.setStudentYearNo(1);
                    studentMapper.insert(student);
                }
                Clazz clazz = new Clazz();
                clazz.setProblemId(problemId);
                clazz.setClazzId(clazzCnt);
                clazz.setClazzName("教学班(专业=" + i + "," + j + ")");
                clazzMapper.insert(clazz);
                clazzCnt ++;
            }
        }
    }

    @Test
    void generateMajors() {
        String[] majors = new String[] { "计算机科学技术", "物联网", "环境工程" };
        for (int i = 1; i <= majors.length; i ++) {
            Major major = new Major();
            major.setProblemId(problemId);
            major.setMajorId(i);
            major.setMajorName(majors[i - 1]);
            majorMapper.insert(major);
        }
    }

    @Test
    void generateSubjects() {
        String[] subjectNames = new String[] {
                "毛泽东思想概论",
                "程序设计艺术",
                "数据结构",
                "高频电子线路",
                "有机化学",
                "水污染控制工程"
        };
        Integer[] subjectTypes = new Integer[] { 1, 3, 2, 3, 2, 3 };
        Integer[] subjectStuCapacity = new Integer[] { 300, 50, 100, 50, 100, 50 };
        for (int i = 1; i <= subjectNames.length; i ++) {
            Subject subject = new Subject();
            subject.setProblemId(problemId);
            subject.setSubjectId(i);
            subject.setSubjectName(subjectNames[i - 1]);
            subject.setSubjectDesc("");
            subject.setSubjectLessonNum(30);
            subject.setSubjectLessonPerWeek(3);
            subject.setSubjectType(subjectTypes[i - 1]);
            subject.setSubjectStuCapacity(subjectStuCapacity[i - 1]);
            subjectMapper.insert(subject);
        }
    }

    @Test
    void generateTeachers() {
        int numTeachers = 5;
        for (int i = 1; i <= numTeachers; i ++) {
            Teacher teacher = new Teacher();
            teacher.setProblemId(problemId);
            teacher.setTeacherId(i);
            teacher.setTeacherName("教师" + i);
            teacherMapper.insert(teacher);
        }
    }

    @Test
    void generateTeacherCanTeachSubject() {

    }

    @Test
    void generateTrainingPlan() {
        Integer[] majorIds = new Integer[] { 1, 1, 1, 2, 2, 2, 3, 3, 3 };
        Integer[] yearNos = new Integer[] { 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        Integer[] subjectIds = new Integer[] { 1, 2, 3, 1, 3, 4, 1, 5, 6 };
        for (int i = 1; i <= majorIds.length; i ++) {
            TrainingPlan trainingPlan = new TrainingPlan();
            trainingPlan.setProblemId(problemId);
            trainingPlan.setTrainingPlanId(i);
            trainingPlan.setMajorId(majorIds[i - 1]);
            trainingPlan.setYearNo(yearNos[i - 1]);
            trainingPlan.setSubjectId(subjectIds[i - 1]);
            trainingPlanMapper.insert(trainingPlan);
        }
    }

    @Test
    void generateClassRoom() {
        Integer[] classRoomCapacities = new Integer[] {
                300, 150, 50
        };
        for (int i = 1; i <= classRoomCapacities.length; i ++) {
            Classroom classroom = new Classroom();
            classroom.setProblemId(problemId);
            classroom.setClassroomId(i);
            classroom.setClassroomCapacity(classRoomCapacities[i - 1]);
            classroom.setClassroomDesc("");
            classroomMapper.insert(classroom);
        }
    }

    @Test
    void testCountStudentsBySubjectId() {
        int cnt = subjectMapper.countStudentHaveSubject(problemId, 1);
        System.out.println(cnt);
    }

    @Test
    void testCalcCourses() {
        List<Subject> subjects = subjectMapper.selectAll(problemId);
        int courseForClazzId = 1;
        int courseId = 0;
        for (Subject subject : subjects) {
            // 计算应该为这门教学科目开几门课
            // 满足以下约束
            // 1. 一个教学班的所有学生在都选同一 course
            // 2. 选一个 course 的学生数 <= subjectCapacity
            int subjectStuCapacity = subject.getSubjectStuCapacity();
            // 选了这门课的教学班
            List<Integer> clazzIdList =
                    subjectMapper.selectAllClazzHaveSubject(problemId, subject.getSubjectId());
            int curRestCapacity = 0; // 当前课程还能容纳多少学生
            int clazzSize = 50;
            for (Integer clazzId : clazzIdList) {
                // 当前课程剩余容量无法容纳这个教学班了, 开一个新 course
                if (curRestCapacity < clazzSize) {
                    courseId ++;
                    Course course = new Course();
                    course.setProblemId(problemId);
                    course.setSubjectId(subject.getSubjectId());
                    course.setCourseId(courseId);
                    course.setCourseName(subject.getSubjectName() + courseId);
                    courseMapper.insert(course);
                    curRestCapacity = subjectStuCapacity;
                }
                curRestCapacity -= clazzSize;
                // 记录这个 course 的目标班级有 clazz
                CourseForClazz courseForClazz = new CourseForClazz();
                courseForClazz.setProblemId(problemId);
                courseForClazz.setCourseForClassId(++ courseForClazzId);
                courseForClazz.setCourseId(courseId);
                courseForClazz.setClazzId(clazzId);
                courseForClazzMapper.insert(courseForClazz);
            }
        }
    }

    @Test
    void testArrange() {
        // clear
        courseMapper.empty();
        lessonMapper.empty();
        teacherTeachCourseMapper.empty();
        // arrange
        List<Course> courseList = courseMapper.selectAll(problemId);
        List<Clazz> clazzList = clazzMapper.selectAll(problemId);
        List<Classroom> classroomList = classroomMapper.selectAll(problemId);
        List<Subject> subjectList = subjectMapper.selectAll(problemId);
        List<Teacher> teacherList = teacherMapper.selectAll(problemId);
        List<TeacherCanTeachSubject> teacherCanTeachSubjectList = teacherCanTeachSubjectMapper.selectAll(problemId);
        List<CourseForClazz> courseForClazzList = courseForClazzMapper.selectAll(problemId);
        Solution problem = Solution.initProblem(
                courseList,
                clazzList,
                classroomList,
                subjectList,
                teacherList,
                teacherCanTeachSubjectList,
                courseForClazzList
        );
        Solution result = problem.solve(60);
        result.persistResult(
                problemId,
                courseMapper,
                teacherTeachCourseMapper,
                lessonMapper
        );
        for (DCourse dCourse : result.getDCourseList()) {
            System.out.printf(
                    "course %d, teacher %d, start from %d-th week\n",
                    dCourse.getId(),
                    dCourse.getDTeacher().getId(),
                    dCourse.getDWeek().getIndex()
            );
            for (DLesson dLesson : dCourse.getLessons()) {
                System.out.printf(
                        "\ttimeslot %d, classroom %d\n",
                        dLesson.getDTimeSlot().getIndex(),
                        dLesson.getDClassroom().getId()
                );
            }
        }
    }
}
