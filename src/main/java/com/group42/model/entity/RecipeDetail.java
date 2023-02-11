package com.group42.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Guofeng Lin
 * @since 2023-02-10
 */
@TableName("recipe_detail")
public class RecipeDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * recipe detail id
     */
    private Long detailId;

    private Long recipeId;

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

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "RecipeDetail{" +
        "detailId = " + detailId +
        ", recipeId = " + recipeId +
        ", ingredientId = " + ingredientId +
        ", userId = " + userId +
        ", weight = " + weight +
        ", calories = " + calories +
        ", createdAt = " + createdAt +
        ", updatedAt = " + updatedAt +
        "}";
    }
}
