package com.yxw.managesystem.mapper;

import com.yxw.managesystem.entity.Teacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 教师表 Mapper 接口
 * </p>
 *
 * @author yyd
 * @since 2023-06-14
 */
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {
    List<Teacher> selectAll();
}
