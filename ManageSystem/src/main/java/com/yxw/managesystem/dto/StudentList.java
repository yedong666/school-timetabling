package com.yxw.managesystem.dto;

import com.yxw.managesystem.entity.Student;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class StudentList implements Serializable {

    private List<Student> studentList;
}
