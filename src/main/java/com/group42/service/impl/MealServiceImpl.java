package com.group42.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group42.dao.MealMapper;
import com.group42.model.entity.Meal;
import com.group42.model.entity.User;
import com.group42.service.IMealService;
import com.group42.service.IUserService;
import com.group42.utils.ExceptionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Guofeng Lin
 * @since 2023-02-10
 */
@Service
public class MealServiceImpl extends ServiceImpl<MealMapper, Meal> implements IMealService {
    private IUserService userService;

    public MealServiceImpl(IUserService userService) {
        this.userService = userService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Meal recommandMeal(Long userId, String mealType) {
        Meal meal = new Meal();
        meal.setUserId(userId);
        meal.setMealType(mealType);
        meal.setTotalWeight(0);
        meal.setTotalCalories(0);
        if (save(meal) && recommendForAMeal(meal)){
            return meal;
        }
        throw ExceptionUtils.newSER("Failed to recommend a meal for user: " + userId);
    }

    private boolean recommendForAMeal(Meal meal){
        // gather information
        User user = userService.getById(meal.getUserId());
        Integer max = user.getTargetCaloriesMax();
        Integer min = user.getTargetCaloriesMin();

        // recommend
        return true;
    }
}
