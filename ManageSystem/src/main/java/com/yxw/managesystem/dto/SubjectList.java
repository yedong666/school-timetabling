package com.yxw.managesystem.dto;

import com.yxw.managesystem.entity.Subject;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SubjectList implements Serializable {

    private List<Subject> subjectList;
}
