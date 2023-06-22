package com.yxw.managesystem.service.impl;

import com.yxw.managesystem.entity.Course;
import com.yxw.managesystem.mapper.CourseMapper;
import com.yxw.managesystem.service.ICourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程表(与教学科目表为一对多关系) 服务实现类
 * </p>
 *
 * @author yyd
 * @since 2023-06-18
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

}
