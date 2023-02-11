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

/**
 * @author Guofeng Lin
 * @since 2023-02-10
 */
@Service
public class RecipeDetailServiceImpl extends ServiceImpl<MealDetailMapper, MealDetail> implements IMealDetailService {

    @Override
    public List<SuggestBaseType> getMealBaseTypeByMealId(Long mealId) {
        return getBaseMapper().selectMealBaseTypeByMealId(mealId);
    }

    @Override
    public List<SuggestBaseType> getMealDetail(Long mealId, Long ingredientId) {
        return getBaseMapper().selectMealDetail(mealId, ingredientId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean confirmMealDetail(Meal meal, List<SuggestBaseType> ingredients) {
        lambdaUpdate().eq(MealDetail::getMealId, meal.getMealId()).remove();
        List<MealDetail> mealDetails = new ArrayList<>(ingredients.size());
        for (SuggestBaseType ingredient : ingredients) {
            MealDetail mealDetail = new MealDetail();
            mealDetail.setMealId(meal.getMealId());
            mealDetail.setIngredientId(ingredient.getIngredientId());
            mealDetail.setUserId(meal.getUserId());
            mealDetail.setWeight(ingredient.getWeight());
            mealDetail.setCalories(ingredient.getCalories());

            mealDetails.add(mealDetail);
        }
        if (saveBatch(mealDetails))
            return true;
        throw ExceptionUtils.newSER("Confirm meal detail failed");
    }
}
