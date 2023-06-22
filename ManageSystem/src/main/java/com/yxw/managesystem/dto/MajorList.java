package com.yxw.managesystem.dto;

import com.yxw.managesystem.entity.Major;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MajorList implements Serializable  {

    private List<Major> majorList;
}
