package com.group42.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group42.dao.MealMapper;
import com.group42.model.entity.Meal;
import com.group42.service.IMealService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Guofeng Lin
 * @since 2023-02-10
 */
@Service
public class MealServiceImpl extends ServiceImpl<MealMapper, Meal> implements IMealService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Meal recommandMeal(Long userId, String mealType) {
        Meal meal = new Meal();
        meal.setUserId(userId);
        meal.setMealType(mealType);
        meal.setTotalWeight(0);
        meal.setTotalCalories(0);

        return save(meal) ? meal : null;
    }
}
