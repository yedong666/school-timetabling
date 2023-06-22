package com.yxw.managesystem.service.impl;

import com.yxw.managesystem.entity.CourseForClazz;
import com.yxw.managesystem.mapper.CourseForClazzMapper;
import com.yxw.managesystem.service.ICourseForClazzService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程与教学班关联表, 记录一门课主要为哪些教学班开设 服务实现类
 * </p>
 *
 * @author yyd
 * @since 2023-06-18
 */
@Service
public class CourseForClazzServiceImpl extends ServiceImpl<CourseForClazzMapper, CourseForClazz> implements ICourseForClazzService {

}
