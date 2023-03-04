package com.group42.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 *
 * @author Guofeng Lin
 * @since 2023-02-27
 */
@TableName("recipe")
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Recipe extends BaseEntity {

    /**
     * recipe Id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long recipeId;

    private String recipeName;

    private Integer recipeCalories;

    /**
     * minutes
     */
    private Integer recipeCookingTime;

    /**
     * numbers of people for recipe
     */
    private Integer recipePortion;

    /**
     * picture for recipe
     */
    private String recipePicUrl;

    /**
     * detail of recipe
     */
    private String recipeDetailUrl;

    /**
     * allergen
     */
    private String description;

}
