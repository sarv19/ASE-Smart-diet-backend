package com.group42.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group42.model.entity.EatingPreference;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Guofeng Lin
 * @since 2023-02-27
 */
public interface EatingPreferenceMapper extends BaseMapper<EatingPreference> {
    List<EatingPreference> selectByUserId(@Param("userId") Long userId);
}
