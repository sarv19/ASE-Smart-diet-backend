package com.group42.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group42.dao.MealDetailMapper;
import com.group42.model.bean.SuggestBaseType;
import com.group42.model.entity.Meal;
import com.group42.model.entity.MealDetail;
import com.group42.service.IMealDetailService;
import com.group42.utils.ExceptionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Guofeng Lin
 * @since 2023-02-10
 */
@Service
public class RecipeDetailServiceImpl extends ServiceImpl<MealDetailMapper, MealDetail> implements IMealDetailService {

    private static final Random random = new Random();

    @Override
    public List<SuggestBaseType> getMealBaseTypeByMealId(Long mealId) {
        return getBaseMapper().selectMealBaseTypeByMealId(mealId);
    }

    @Override
    public List<SuggestBaseType> getMealDetail(Long mealId, Long ingredientId) {
        List<SuggestBaseType> result = getBaseMapper().selectMealDetail(mealId, ingredientId);
        for (SuggestBaseType type : result) {
            System.out.println(type);
            type.setCalories((int) ((type.getTargetCaloriesMax() + type.getTargetCaloriesMin()) * 1.0 / 2));
            type.setWeight((int) (type.getCalories() / (type.getIngredientCalories() * 1.0) * 100));
            type.setCalories((int) (type.getWeight() * (type.getIngredientCalories() * 1.0) / 100));
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean confirmMealDetail(Meal meal, List<SuggestBaseType> ingredients) {
        lambdaUpdate().eq(MealDetail::getMealId, meal.getMealId()).remove();
        List<MealDetail> mealDetails = new ArrayList<>(ingredients.size());
        for (SuggestBaseType ingredient : ingredients) {
            MealDetail mealDetail = new MealDetail();
            mealDetail.setMealId(meal.getMealId()).setUserId(meal.getUserId()).setUserUid(meal.getUserUid());
            mealDetail.setIngredientId(ingredient.getIngredientId());
            mealDetail.setWeight(ingredient.getWeight()).setCalories(ingredient.getCalories());

            mealDetails.add(mealDetail);
        }
        if (saveBatch(mealDetails))
            return true;
        throw ExceptionUtils.newSE("Confirm meal detail failed");
    }
}
