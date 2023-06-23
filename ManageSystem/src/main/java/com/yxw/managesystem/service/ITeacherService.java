package com.yxw.managesystem.service;

import com.yxw.managesystem.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 教师表 服务类
 * </p>
 *
 * @author yyd
 * @since 2023-06-14
 */
public interface ITeacherService extends IService<Teacher> {

    boolean addTeachers(List<Teacher> teacherList);
}
