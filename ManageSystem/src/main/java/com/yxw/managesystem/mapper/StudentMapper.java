package com.yxw.managesystem.mapper;

import com.yxw.managesystem.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 学生表 Mapper 接口
 * </p>
 *
 * @author yyd
 * @since 2023-06-14
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    List<Student> selectAll();
}
