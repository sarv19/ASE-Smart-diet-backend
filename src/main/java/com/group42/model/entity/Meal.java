package com.group42.model.entity;

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
public class Meal implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * meal Id
     */
    private Long mealId;

    private Long userId;

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

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Long getMealId() {
        return mealId;
    }

    public void setMealId(Long mealId) {
        this.mealId = mealId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public LocalDateTime getMealDate() {
        return mealDate;
    }

    public void setMealDate(LocalDateTime mealDate) {
        this.mealDate = mealDate;
    }

    public Integer getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Integer totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Integer getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(Integer totalCalories) {
        this.totalCalories = totalCalories;
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
        return "Meal{" +
        "mealId = " + mealId +
        ", userId = " + userId +
        ", mealType = " + mealType +
        ", mealDate = " + mealDate +
        ", totalWeight = " + totalWeight +
        ", totalCalories = " + totalCalories +
        ", createdAt = " + createdAt +
        ", updatedAt = " + updatedAt +
        "}";
    }
}
