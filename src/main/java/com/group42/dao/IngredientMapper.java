package com.group42.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group42.model.entity.Ingredient;
import com.group42.model.vo.IngredientVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Guofeng Lin
 * @since 2023-02-10
 */
public interface IngredientMapper extends BaseMapper<Ingredient> {
    List<IngredientVO> selectIngredientsByPreference(@Param("userId") Long userId);

}
