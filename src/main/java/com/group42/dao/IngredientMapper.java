package com.group42.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group42.model.entity.Ingredient;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * @author Guofeng Lin
 * @since 2023-02-10
 */
public interface IngredientMapper extends BaseMapper<Ingredient> {
    List<Ingredient> selectRecommendByPreference(@Param("userId") Long userId);

}
