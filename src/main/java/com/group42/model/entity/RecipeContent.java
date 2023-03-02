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
 * @since 2023-02-27
 */
@TableName("recipe_content")
public class RecipeContent implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * recipe ingredient relationship id
     */
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

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Long getRecipeContentId() {
        return recipeContentId;
    }

    public void setRecipeContentId(Long recipeContentId) {
        this.recipeContentId = recipeContentId;
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

    public Long getSeasonerId() {
        return seasonerId;
    }

    public void setSeasonerId(Long seasonerId) {
        this.seasonerId = seasonerId;
    }

    public Boolean getRecipeContentIngredient() {
        return recipeContentIngredient;
    }

    public void setRecipeContentIngredient(Boolean recipeContentIngredient) {
        this.recipeContentIngredient = recipeContentIngredient;
    }

    public Boolean getRecipeContentSeasoner() {
        return recipeContentSeasoner;
    }

    public void setRecipeContentSeasoner(Boolean recipeContentSeasoner) {
        this.recipeContentSeasoner = recipeContentSeasoner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return "RecipeContent{" +
        "recipeContentId = " + recipeContentId +
        ", recipeId = " + recipeId +
        ", ingredientId = " + ingredientId +
        ", seasonerId = " + seasonerId +
        ", recipeContentIngredient = " + recipeContentIngredient +
        ", recipeContentSeasoner = " + recipeContentSeasoner +
        ", description = " + description +
        ", createdAt = " + createdAt +
        ", updatedAt = " + updatedAt +
        "}";
    }
}
