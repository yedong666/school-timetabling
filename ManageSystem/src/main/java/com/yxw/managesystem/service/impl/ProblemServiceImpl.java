package com.yxw.managesystem.service.impl;

import com.yxw.managesystem.entity.Problem;
import com.yxw.managesystem.mapper.ProblemMapper;
import com.yxw.managesystem.service.IProblemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 问题表 服务实现类
 * </p>
 *
 * @author yyd
 * @since 2023-06-23
 */
@Service
public class ProblemServiceImpl extends ServiceImpl<ProblemMapper, Problem> implements IProblemService {

    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public List<Problem> getAllProblems() {
        try {
            return problemMapper.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
