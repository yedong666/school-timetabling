package com.yxw.managesystem.mapper;

import com.yxw.managesystem.entity.Classroom;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 教室信息表 Mapper 接口
 * </p>
 *
 * @author yyd
 * @since 2023-06-14
 */
@Mapper
public interface ClassroomMapper extends BaseMapper<Classroom> {
    List<Classroom> selectAll();
}
