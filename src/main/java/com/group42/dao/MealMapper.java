package com.group42.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group42.model.entity.Meal;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Guofeng Lin
 * @since 2023-02-10
 */
public interface MealMapper extends BaseMapper<Meal> {
    Meal findTodayMealByUserUid(@Param("userUid") String userUid, @Param("mealType") String mealType);
}
