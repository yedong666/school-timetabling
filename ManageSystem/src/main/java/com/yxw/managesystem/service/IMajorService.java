package com.yxw.managesystem.service;

import com.yxw.managesystem.entity.Major;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yxw.managesystem.mapper.MajorMapper;

import javax.annotation.Nullable;
import java.util.List;

/**
 * <p>
 * 培养计划表 服务类
 * </p>
 *
 * @author yyd
 * @since 2023-06-14
 */
public interface IMajorService extends IService<Major> {

    boolean addMajors(List<Major> majorList);

    @Nullable
    List<Major> getAllMajors(String problemId);
}
