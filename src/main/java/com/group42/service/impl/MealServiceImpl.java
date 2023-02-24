package com.group42.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group42.constant.SuggestStrategy;
import com.group42.dao.MealMapper;
import com.group42.model.entity.IngredientType;
import com.group42.model.entity.Meal;
import com.group42.model.entity.MealDetail;
import com.group42.model.entity.User;
import com.group42.service.IIngredientTypeService;
import com.group42.service.IMealDetailService;
import com.group42.service.IMealService;
import com.group42.service.IUserService;
import com.group42.utils.ExceptionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Guofeng Lin
 * @since 2023-02-10
 */
@Service
public class MealServiceImpl extends ServiceImpl<MealMapper, Meal> implements IMealService {
    private final IUserService userService;
    private final IIngredientTypeService ingredientTypeService;
    private final IMealDetailService mealDetailService;

    public MealServiceImpl(IUserService userService, IIngredientTypeService ingredientTypeService, IMealDetailService mealDetailService) {
        this.userService = userService;
        this.ingredientTypeService = ingredientTypeService;
        this.mealDetailService = mealDetailService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Meal recommandMeal(Long userId, String mealType) {
        Meal meal = new Meal();
        meal.setUserId(userId);
        meal.setMealType(mealType);
        meal.setTotalWeight(0);
        meal.setTotalCalories(0);
        if (save(meal) && prepareRecommend(meal)) {
            return meal;
        }
        throw ExceptionUtils.newSE("Failed to recommend a meal for user: " + userId);
    }

    @Override
    public Meal confirmMeal(Long mealId, int totalCalories, int totalWeight) {
        Meal one = Optional.ofNullable(lambdaQuery().eq(Meal::getMealId, mealId).isNull(Meal::getMealDate).one())
                .orElseThrow(() -> ExceptionUtils.newSE("Meal: " + mealId + " has been confirmed before"));
        lambdaUpdate().eq(Meal::getMealId, mealId)
                .set(Meal::getTotalCalories, totalCalories)
                .set(Meal::getTotalWeight, totalWeight)
                .set(Meal::getMealDate, new Date())
                .update();
        return one;
    }

    private boolean prepareRecommend(Meal meal) {
        // gather information
        // 1. user's target calories
        User user = userService.getById(meal.getUserId());
        Integer max = user.getTargetCaloriesMax();
        Integer min = user.getTargetCaloriesMin();
        if (max == null || min == null) {
            throw ExceptionUtils.newSE("User: " + user.getUserId() + " has not set target calories");
        }
        if (max < 1 || min < 1) {
            throw ExceptionUtils.newSE("User: " + user.getUserId() + " has set target calories incorrectly");
        }
        if (max < min) { // swap values
            max ^= min;
            min ^= max;
            max ^= min;
        }
        Integer proportion = SuggestStrategy.getProportionByMealType(meal.getMealType());
        max = max * proportion / 100;
        min = min * proportion / 100;
        // 2. ingredients by preference (include type group information)
        List<IngredientType> acceptableType = ingredientTypeService.getAcceptableBaseType(meal.getUserId());
        // recommend by type
        List<MealDetail> mealDetails = new ArrayList<>(acceptableType.size() * 2);
        for (IngredientType type : acceptableType) {
            MealDetail mealDetail = new MealDetail();
            mealDetail.setMealId(meal.getMealId());
            mealDetail.setIngredientId(type.getTypeId());
            mealDetail.setUserId(meal.getUserId());
            mealDetail.setWeight(100);
            mealDetail.setCalories(100);
            mealDetails.add(mealDetail);
        }
        return mealDetailService.saveBatch(mealDetails);
    }
}
