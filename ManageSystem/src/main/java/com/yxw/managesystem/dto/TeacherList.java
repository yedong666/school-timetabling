package com.yxw.managesystem.dto;

import com.yxw.managesystem.entity.Teacher;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TeacherList implements Serializable {

    private List<Teacher> teacherList;
}
