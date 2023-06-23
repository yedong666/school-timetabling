package com.yxw.managesystem.dto;

import com.yxw.managesystem.entity.TeacherCanTeachSubject;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TeacherCanTeachSubjectList implements Serializable {

    private List<TeacherCanTeachSubject> teacherCanTeachSubjectList;
}
