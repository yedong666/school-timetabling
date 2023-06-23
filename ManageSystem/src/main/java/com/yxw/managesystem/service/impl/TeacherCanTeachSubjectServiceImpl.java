package com.yxw.managesystem.service.impl;

import com.yxw.managesystem.entity.TeacherCanTeachSubject;
import com.yxw.managesystem.mapper.TeacherCanTeachSubjectMapper;
import com.yxw.managesystem.service.ITeacherCanTeachSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 教师与教学科目关联表(多对多关系) 服务实现类
 * </p>
 *
 * @author yyd
 * @since 2023-06-14
 */
@Service
public class TeacherCanTeachSubjectServiceImpl extends ServiceImpl<TeacherCanTeachSubjectMapper, TeacherCanTeachSubject> implements ITeacherCanTeachSubjectService {

    @Autowired
    private TeacherCanTeachSubjectMapper teacherCanTeachSubjectMapper;

    @Override
    public boolean addTeacherCanTeachSubjectList(List<TeacherCanTeachSubject> teacherCanTeachSubjectList) {
        try {
            for (TeacherCanTeachSubject teacherCanTeachSubject : teacherCanTeachSubjectList) {
                teacherCanTeachSubjectMapper.insert(teacherCanTeachSubject);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
