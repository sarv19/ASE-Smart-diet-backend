package com.group42.model.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * SuggestMealDetail
 *
 * @author Guofeng Lin
 * @since 2023/2/11
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuggestMealDetail {
    private Long ingredientId;
    private Long typeId;
    private String ingredientName;
    private String description;
    private Integer calories;
    private Integer weight;
    @JsonIgnore
    private Integer targetCaloriesMin;
    @JsonIgnore
    private Integer targetCaloriesMax;
    @JsonIgnore
    private Integer ingredientCalories;

}
