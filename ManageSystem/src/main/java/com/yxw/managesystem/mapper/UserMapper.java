package com.yxw.managesystem.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yxw.managesystem.entity.TrainingPlan;
import com.yxw.managesystem.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
