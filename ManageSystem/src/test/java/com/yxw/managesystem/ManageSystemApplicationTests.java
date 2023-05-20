package com.yxw.managesystem;

import com.yxw.managesystem.entity.Student;
import com.yxw.managesystem.entity.StudentShouldSelectSubject;
import com.yxw.managesystem.mapper.StudentMapper;
import com.yxw.managesystem.mapper.StudentShouldSelectSubjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ManageSystemApplicationTests {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentShouldSelectSubjectMapper studentShouldSelectSubjectMapper;

    @Test
    void contextLoads() {
        Student student = new Student();
        student.setStudentClass(1);
        student.setStudentName("tom");
        student.setStudentGrade(2);
        studentMapper.insert(student);
    }

    @Test
    void test() {
        StudentShouldSelectSubject studentShouldSelectSubject = new StudentShouldSelectSubject();
        studentShouldSelectSubject.setStudentId(1);
        studentShouldSelectSubject.setSubjectId(1);
        studentShouldSelectSubjectMapper.insert(studentShouldSelectSubject);
    }

}
