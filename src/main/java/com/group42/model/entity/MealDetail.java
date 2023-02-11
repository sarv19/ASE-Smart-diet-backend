package com.group42.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 *
 * @author Guofeng Lin
 * @since 2023-02-10
 */
@TableName("meal_detail")
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MealDetail extends BaseEntity {

    /**
     * recipe detail id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long detailId;

    private Long mealId;

    private Long ingredientId;

    private Long userId;

    /**
     * weight(g) of this ingredient in this recipe * 1000
     */
    private Integer weight;

    /**
     * calories(mg) of this ingredient in this recipe
     */
    private Integer calories;
}
