package com.yxw.managesystem.service.impl;

import com.yxw.managesystem.entity.Classroom;
import com.yxw.managesystem.entity.Clazz;
import com.yxw.managesystem.mapper.ClassroomMapper;
import com.yxw.managesystem.mapper.ClazzMapper;
import com.yxw.managesystem.service.IClazzService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 教学班表 服务实现类
 * </p>
 *
 * @author yyd
 * @since 2023-06-18
 */
@Service
public class ClazzServiceImpl extends ServiceImpl<ClazzMapper, Clazz> implements IClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public boolean addClazzs(List<Clazz> clazzList) {
        try {
            for (Clazz clazz : clazzList) {
                clazzMapper.insert(clazz);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
