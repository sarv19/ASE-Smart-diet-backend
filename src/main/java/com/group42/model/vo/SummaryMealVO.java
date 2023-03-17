package com.group42.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * SummaryMealVO
 *
 * @author Guofeng Lin
 * @since 2023/3/16
 */
@Data
public class SummaryMealVO {
    private Long mealId;
    /**
     * breakfast, lunch, dinner, snack
     */
    private String mealType;

    private LocalDateTime mealDate;

    /**
     * total weight(g) of one meal
     */
    private Integer totalWeight;

    /**
     * total calories(mg) of one meal
     */
    private Integer totalCalories;
    private Integer totalProtein;
    private Integer totalFat;
    private Integer totalCarbohydrate;
    private Integer totalSodium;

}
