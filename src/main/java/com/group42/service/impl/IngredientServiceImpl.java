package com.group42.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group42.dao.IngredientMapper;
import com.group42.model.entity.Ingredient;
import com.group42.model.entity.MealDetail;
import com.group42.service.IIngredientService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Guofeng Lin
 * @since 2023-02-10
 */
@Service
public class IngredientServiceImpl extends ServiceImpl<IngredientMapper, Ingredient> implements IIngredientService {

    @Override
    public List<MealDetail> recommendByBaseType(Long userId, Map<Long, MealDetail> detailMap) {
        List<Ingredient> ingredients = getBaseMapper().selectRecommendByPreference(userId);
        List<MealDetail> mealDetails = new ArrayList<>(detailMap.size());
        for (Ingredient ingredient : ingredients) {
            MealDetail mealDetail = detailMap.get(ingredient.getTypeId());
            if (mealDetail == null) {
                continue;
            }
            mealDetail.setIngredientId(ingredient.getIngredientId());
//            mealDetail.setWeight((int) (mealDetail.getCalories() * 1.0 / ingredient.getCalories()));
            mealDetails.add(mealDetail);
        }
        return mealDetails;
    }
}
