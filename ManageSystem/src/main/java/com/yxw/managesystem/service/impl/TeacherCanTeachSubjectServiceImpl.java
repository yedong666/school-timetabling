package com.yxw.managesystem.service.impl;

import com.yxw.managesystem.entity.TeacherCanTeachSubject;
import com.yxw.managesystem.mapper.TeacherCanTeachSubjectMapper;
import com.yxw.managesystem.service.ITeacherCanTeachSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 教师与教学科目关联表(多对多关系) 服务实现类
 * </p>
 *
 * @author yyd
 * @since 2023-05-24
 */
@Service
public class TeacherCanTeachSubjectServiceImpl extends ServiceImpl<TeacherCanTeachSubjectMapper, TeacherCanTeachSubject> implements ITeacherCanTeachSubjectService {

}
