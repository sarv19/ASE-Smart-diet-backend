package com.group42.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group42.model.entity.IngredientType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Guofeng Lin
 * @since 2023-02-11
 */
public interface IngredientTypeMapper extends BaseMapper<IngredientType> {
    List<IngredientType> selectAcceptableBaseType(@Param("userId") Long userId);
}
