package com.group42.model.vo;

import lombok.Data;

/**
 * SummaryDetailVO
 *
 * @author Guofeng Lin
 * @since 2023/3/16
 */
@Data
public class SummaryDetailVO {
    private Long ingredientId;
    private Long mealId;
    private Integer weight;
    /**
     * mg/1000g
     */
    private Integer calories;

    /**
     * mg/1000g
     */
    private Integer fat;

    /**
     * mg/1000g
     */
    private Integer carbohydrate;

    /**
     * mg/1000g
     */
    private Integer protein;

    /**
     * mg/1000g
     */
    private Integer sodium;


}
