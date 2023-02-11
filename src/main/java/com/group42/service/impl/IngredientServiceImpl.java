package com.group42.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group42.dao.IngredientMapper;
import com.group42.model.entity.Ingredient;
import com.group42.model.vo.IngredientVO;
import com.group42.service.IIngredientService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Guofeng Lin
 * @since 2023-02-10
 */
@Service
public class IngredientServiceImpl extends ServiceImpl<IngredientMapper, Ingredient> implements IIngredientService {

    @Override
    public List<IngredientVO> getIngredientsBySuggest(Long userId, Long mealId) {
        List<IngredientVO> result = getBaseMapper().selectIngredientsByPreference(userId);
        return suggestForAMeal(result);
    }

    private List<IngredientVO> suggestForAMeal(List<IngredientVO> ingredients){
        for (IngredientVO ingredient : ingredients) {
            ingredient.setWeight(100);
            ingredient.setCalories(100);
        }
        return ingredients;
    }
}
