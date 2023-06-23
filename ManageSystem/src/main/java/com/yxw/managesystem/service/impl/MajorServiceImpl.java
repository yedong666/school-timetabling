package com.yxw.managesystem.service.impl;

import com.yxw.managesystem.entity.Major;
import com.yxw.managesystem.mapper.MajorMapper;
import com.yxw.managesystem.service.IMajorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
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
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Nullable
    @Override
    public List<Major> getAllMajors(String problemId) {
        try {
            return majorMapper.selectAll(problemId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
