package com.group42.model.entity;

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
public class Recipe implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * recipe Id
     */
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

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public Integer getRecipeCalories() {
        return recipeCalories;
    }

    public void setRecipeCalories(Integer recipeCalories) {
        this.recipeCalories = recipeCalories;
    }

    public Integer getRecipeCookingTime() {
        return recipeCookingTime;
    }

    public void setRecipeCookingTime(Integer recipeCookingTime) {
        this.recipeCookingTime = recipeCookingTime;
    }

    public Integer getRecipePortion() {
        return recipePortion;
    }

    public void setRecipePortion(Integer recipePortion) {
        this.recipePortion = recipePortion;
    }

    public String getRecipePicUrl() {
        return recipePicUrl;
    }

    public void setRecipePicUrl(String recipePicUrl) {
        this.recipePicUrl = recipePicUrl;
    }

    public String getRecipeDetailUrl() {
        return recipeDetailUrl;
    }

    public void setRecipeDetailUrl(String recipeDetailUrl) {
        this.recipeDetailUrl = recipeDetailUrl;
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
        return "Recipe{" +
        "recipeId = " + recipeId +
        ", recipeName = " + recipeName +
        ", recipeCalories = " + recipeCalories +
        ", recipeCookingTime = " + recipeCookingTime +
        ", recipePortion = " + recipePortion +
        ", recipePicUrl = " + recipePicUrl +
        ", recipeDetailUrl = " + recipeDetailUrl +
        ", description = " + description +
        ", createdAt = " + createdAt +
        ", updatedAt = " + updatedAt +
        "}";
    }
}
