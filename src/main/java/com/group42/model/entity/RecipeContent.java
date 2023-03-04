package com.group42.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Guofeng Lin
 * @since 2023-02-27
 */
@TableName("recipe_content")
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class RecipeContent extends BaseEntity {

    /**
     * recipe ingredient relationship id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long recipeContentId;

    /**
     * recipe id
     */
    private Long recipeId;

    /**
     * ingredient id
     */
    private Long ingredientId;

    /**
     * seasoner id
     */
    private Long seasonerId;

    /**
     * true for have, false for none
     */
    private Boolean recipeContentIngredient;

    /**
     * true for have, false for none
     */
    private Boolean recipeContentSeasoner;

    /**
     * comment for relationship
     */
    private String description;
}
