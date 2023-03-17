package com.group42.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group42.model.entity.Meal;
import com.group42.model.vo.SummaryMealVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Guofeng Lin
 * @since 2023-02-10
 */
public interface MealMapper extends BaseMapper<Meal> {
    Meal findTodayMealByUserUid(@Param("userUid") String userUid, @Param("mealType") String mealType);

    Boolean insertIgnore(@Param("meal") Meal meal);

    Long getCurrentMealId(@Param("userUid") String userUid, @Param("mealType") String mealType);

    List<SummaryMealVO> selectSummaryMeal(@Param("userUid") String userUid, @Param("day") int day);
}
