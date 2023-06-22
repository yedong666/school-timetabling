//package com.yxw.managesystem.service;
//
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.yxw.managesystem.mapper.StudentMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service("DataControlService")
//public class DataControlService extends ServiceImpl<> {
//
//    @Autowired
//    private StudentMapper studentMapper;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    /**
//     * 清空所有表 (除了用户相关的表)
//     */
//    public void reset() {
//
//    }
//
//
//    public void addStudents(JsonNode json) {
//        int clazzSize = json.get("clazzSize").asInt();
//        JsonNode students = json.get("students");
//
//    }
//}
