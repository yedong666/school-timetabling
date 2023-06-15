package com.yxw.managesystem;

import com.yxw.managesystem.common.planner.DCourse;
import com.yxw.managesystem.common.planner.DWeek;
import com.yxw.managesystem.common.planner.Solution;
import com.yxw.managesystem.entity.*;
import com.yxw.managesystem.mapper.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

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

    @Test
    void generateStudents() {
        // 生成学生数据
        int[] majorSizeArr = new int[]{ 150, 100, 50 };
        int classSize = 50; // 一个班的人数
        int cnt = 1;
        for (int i = 1; i <= majorSizeArr.length; i ++) {
            int majorSize = majorSizeArr[i - 1];
            int classNum = majorSize % classSize == 0
                    ? majorSize / classSize
                    : majorSize / classSize + 1;
            for (int j = 1; j <= classNum; j ++) {
                for (int k = 0; k < classSize; k ++) {
                    Student student = new Student();
                    student.setStudentId(cnt);
                    student.setStudentName("学生" + cnt ++);
                    student.setStudentClass(j);
                    student.setMajorId(i);
                    student.setStudentEnterTime(LocalDateTime.of(2023, Month.SEPTEMBER, 3, 0, 0));
                    student.setStudentYearNo(1);
                    studentMapper.insert(student);
                }
            }
        }
    }

    @Test
    void generateMajors() {
        String[] majors = new String[] { "计算机科学技术", "物联网", "环境工程" };
        for (int i = 1; i <= majors.length; i ++) {
            Major major = new Major();
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
            classroom.setClassroomId(i);
            classroom.setClassroomCapacity(classRoomCapacities[i - 1]);
            classroom.setClassroomDesc("");
            classroomMapper.insert(classroom);
        }
    }

    @Test
    void testCountStudentsBySubjectId() {
        int cnt = subjectMapper.countStudentsBySubjectId(1);
        System.out.println(cnt);
    }

    @Test
    void testCalcCourses() {
        List<Subject> subjects = subjectMapper.selectAll();
        int cnt = 1;
        for (Subject subject : subjects) {
            int countStudents = subjectMapper.countStudentsBySubjectId(subject.getSubjectId());
            // 应该为这门教学科目开几门课
            int countCourses = countStudents % subject.getSubjectStuCapacity() == 0
                    ? countStudents / subject.getSubjectStuCapacity()
                    : countStudents / subject.getSubjectStuCapacity() + 1;
            for (int i = 1; i <= countCourses; i ++) {
                Course course = new Course();
                course.setCourseId(cnt ++);
                course.setCourseName(subject.getSubjectName() + i);
                course.setSubjectId(subject.getSubjectId());
//                System.out.println(course.getCourseName());
                courseMapper.insert(course);
            }
        }
    }

    @Test
    void testArrange() {
        List<Course> courseList = courseMapper.selectAll();
        List<Classroom> classroomList = classroomMapper.selectAll();
        List<Subject> subjectList = subjectMapper.selectAll();
        Solution problem = Solution.initProblem(courseList, classroomList, subjectList);
        Solution result = Solution.solve(problem);
        System.out.println(result);
    }
}
