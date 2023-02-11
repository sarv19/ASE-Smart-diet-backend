package com.group42.model.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.group42.model.entity.Ingredient;
import com.group42.model.entity.IngredientType;
import com.group42.model.entity.MealDetail;
import lombok.Data;

/**
 * SuggestIngredient
 *
 * @author Guofeng Lin
 * @since 2023/2/11
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuggestIngredient {
    private IngredientType ingredientType;
    private Ingredient ingredient;
    private MealDetail mealDetail;
}
