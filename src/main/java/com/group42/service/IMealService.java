package com.group42.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.group42.model.entity.Meal;
import org.springframework.lang.Nullable;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Guofeng Lin
 * @since 2023-02-10
 */
public interface IMealService extends IService<Meal> {
    @Nullable
    Meal InitMeal(String userUid, String mealType);
    Meal getTodayMeal(String userUid, String mealType);

    Meal confirmMeal(Long mealId, int totalCalories, int totalWeight);
    boolean isConfirmMeal(Meal meal);
    boolean isConfirmMeal(String mealId);
}
