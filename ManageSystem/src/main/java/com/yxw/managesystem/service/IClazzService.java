package com.yxw.managesystem.service;

import com.yxw.managesystem.entity.Clazz;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 教学班表 服务类
 * </p>
 *
 * @author yyd
 * @since 2023-06-18
 */
public interface IClazzService extends IService<Clazz> {

    boolean addClazzs(List<Clazz> clazzList);
}
