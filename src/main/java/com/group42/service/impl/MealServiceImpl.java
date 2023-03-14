package com.group42.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group42.constant.SuggestStrategy;
import com.group42.dao.MealMapper;
import com.group42.model.entity.IngredientType;
import com.group42.model.entity.Meal;
import com.group42.model.entity.MealDetail;
import com.group42.model.entity.UserTarget;
import com.group42.service.*;
import com.group42.utils.ExceptionUtils;
import com.group42.utils.SeqUtils;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.*;

/**
 * @author Guofeng Lin
 * @since 2023-02-10
 */
@Service
public class MealServiceImpl extends ServiceImpl<MealMapper, Meal> implements IMealService {
    private final IIngredientTypeService ingredientTypeService;
    private final IIngredientService ingredientService;
    private final IMealDetailService mealDetailService;
    private final IUserTargetService userTargetService;

    public MealServiceImpl(
            IIngredientTypeService ingredientTypeService,
            IIngredientService ingredientService,
            IMealDetailService mealDetailService,
            IUserTargetService userTargetService
    ) {
        this.ingredientTypeService = ingredientTypeService;
        this.ingredientService = ingredientService;
        this.mealDetailService = mealDetailService;
        this.userTargetService = userTargetService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @Nullable
    public Meal InitMeal(String userUid, String mealType) {
        UserTarget userTarget = userTargetService.findActiveTargetByUid(userUid);
        Meal meal = new Meal().setMealId(SeqUtils.getId());
        meal.setUserId(userTarget.getUserId()).setUserUid(userUid);
        meal.setMealType(mealType);
        Integer max = userTarget.getTargetCaloriesMax();
        Integer min = userTarget.getTargetCaloriesMin();
        if (max == null || min == null) {
            throw ExceptionUtils.newSE("User: " + userTarget.getUserId() + " has not set target calories");
        }
        if (max < 1 || min < 1) {
            throw ExceptionUtils.newSE("User: " + userTarget.getUserId() + " has set target calories incorrectly");
        }
        if (max < min) { // swap values
            max ^= min;
            min ^= max;
            max ^= min;
        }
        Integer proportion = SuggestStrategy.getProportionByMealType(meal.getMealType());
        max = max * proportion / 100;
        min = min * proportion / 100;
        // if fail to save a meal at this time, means that it is saved before
        if (getBaseMapper().insertIgnore(meal.setTotalWeight(min).setTotalCalories(max)) && prepareRecommend(meal)) {
            return meal;
        }
        return null;
    }

    @Override
    public Meal getTodayMeal(String userUid, String mealType) {
        return getBaseMapper().findTodayMealByUserUid(userUid, mealType);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
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

    @Override
    public boolean isConfirmMeal(Meal meal) {
        return !ObjectUtils.isEmpty(meal.getMealDate());
    }

    @Override
    public boolean isConfirmMeal(String mealId) {
        return isConfirmMeal(getById(mealId));
    }

    private boolean prepareRecommend(Meal meal) {
        // ingredients by preference (include type group information)
        List<IngredientType> acceptableType = ingredientTypeService.getAcceptableType(meal.getUserId());
        // recommend by type
        Map<Long, MealDetail> typeMap = new HashMap<>(acceptableType.size() * 2);
        for (IngredientType type : acceptableType) {
            MealDetail mealDetail = new MealDetail();
            mealDetail.setMealId(meal.getMealId()).setUserId(meal.getUserId()).setUserUid(meal.getUserUid());
            Integer proportion = SuggestStrategy.getProportionByFoodType(type.getTypeName());
//            proportion = proportion * SuggestStrategy.getProportionByBaseType(type.getBaseTypeName()) / 100;
            mealDetail.setIngredientId(type.getTypeId());
            mealDetail.setWeight((int) (meal.getTotalWeight() * proportion / 100.0))
                    .setCalories((int) (meal.getTotalCalories() * proportion / 100.0));
            typeMap.put(type.getTypeId(), mealDetail);
        }
        // recommend by base type
        return mealDetailService.saveBatch(ingredientService.recommendByBaseType(meal.getUserId(), typeMap));
    }
}
