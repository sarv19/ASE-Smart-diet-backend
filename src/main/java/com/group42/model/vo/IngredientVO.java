package com.group42.model.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * IngredientVO
 *
 * @author Guofeng Lin
 * @since 2023/2/10
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IngredientVO {
    private Long ingredientId;
    private Long detailId;
    private String ingredientName;
    private String description;
    private Integer calories;
    private Integer fat;
    private Integer carbohydrate;
    private Integer protein;
    private Integer sodium;
    private Integer quantity;
    private Integer weight;

}
