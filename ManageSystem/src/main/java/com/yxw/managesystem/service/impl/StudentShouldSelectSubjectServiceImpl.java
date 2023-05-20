package com.yxw.managesystem.service.impl;

import com.yxw.managesystem.entity.StudentShouldSelectSubject;
import com.yxw.managesystem.mapper.StudentShouldSelectSubjectMapper;
import com.yxw.managesystem.service.IStudentShouldSelectSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生与教学科目关联表(多对多关系) 服务实现类
 * </p>
 *
 * @author yyd
 * @since 2023-05-20
 */
@Service
public class StudentShouldSelectSubjectServiceImpl extends ServiceImpl<StudentShouldSelectSubjectMapper, StudentShouldSelectSubject> implements IStudentShouldSelectSubjectService {

}
