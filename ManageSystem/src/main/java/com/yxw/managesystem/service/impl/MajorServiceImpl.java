package com.yxw.managesystem.service.impl;

import com.yxw.managesystem.entity.Major;
import com.yxw.managesystem.mapper.MajorMapper;
import com.yxw.managesystem.service.IMajorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 培养计划表 服务实现类
 * </p>
 *
 * @author yyd
 * @since 2023-06-14
 */
@Service
public class MajorServiceImpl extends ServiceImpl<MajorMapper, Major> implements IMajorService {

    @Autowired
    private MajorMapper majorMapper;

    @Override
    public boolean addMajors(List<Major> majorList) {
        try {
            for (Major major : majorList) {
                majorMapper.insert(major);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
