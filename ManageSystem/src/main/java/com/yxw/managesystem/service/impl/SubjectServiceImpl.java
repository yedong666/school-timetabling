package com.yxw.managesystem.service.impl;

import com.yxw.managesystem.entity.Subject;
import com.yxw.managesystem.mapper.SubjectMapper;
import com.yxw.managesystem.service.ISubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import java.util.List;

/**
 * <p>
 * 教学科目表 服务实现类
 * </p>
 *
 * @author yyd
 * @since 2023-06-14
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements ISubjectService {

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public boolean addSubjects(List<Subject> subjectList) {
        try {
            for (Subject subject : subjectList) {
                subjectMapper.insert(subject);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Nullable
    @Override
    public List<Subject> getAllSubjects(String problemId) {
        try {
            return subjectMapper.selectAll(problemId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
