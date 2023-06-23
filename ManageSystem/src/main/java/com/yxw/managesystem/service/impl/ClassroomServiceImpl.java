package com.yxw.managesystem.service.impl;

import com.yxw.managesystem.entity.Classroom;
import com.yxw.managesystem.entity.Major;
import com.yxw.managesystem.mapper.ClassroomMapper;
import com.yxw.managesystem.service.IClassroomService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import java.util.List;

/**
 * <p>
 * 教室信息表 服务实现类
 * </p>
 *
 * @author yyd
 * @since 2023-06-14
 */
@Service
public class ClassroomServiceImpl extends ServiceImpl<ClassroomMapper, Classroom> implements IClassroomService {

    @Autowired
    private ClassroomMapper classroomMapper;

    @Override
    public boolean addClassrooms(List<Classroom> classroomList) {
        try {
            for (Classroom major : classroomList) {
                classroomMapper.insert(major);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Nullable
    @Override
    public List<Classroom> getAllClassrooms(String problemId) {
        try {
            return classroomMapper.selectAll(problemId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
