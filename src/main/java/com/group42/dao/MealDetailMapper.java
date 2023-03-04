package com.group42.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group42.model.bean.SuggestMealDetail;
import com.group42.model.entity.MealDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Guofeng Lin
 * @since 2023-02-10
 */
public interface MealDetailMapper extends BaseMapper<MealDetail> {
    List<SuggestMealDetail> selectMealBaseTypeByMealId(@Param("mealId") Long mealId);

    List<SuggestMealDetail> selectMealDetail(@Param("userUid") String userUid, @Param("mealId") Long mealId,
                                             @Param("ingredientId") Long ingredientId);
}
