package com.yxw.managesystem.dto;

import com.yxw.managesystem.entity.Classroom;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ClassroomList implements Serializable {

    private List<Classroom> classroomList;
}
