package com.yxw.managesystem.mapper;

import com.yxw.managesystem.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 学生表 Mapper 接口
 * </p>
 *
 * @author yyd
 * @since 2023-05-20
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
