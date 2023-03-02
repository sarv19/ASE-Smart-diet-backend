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
@TableName("eating_preference")
public class EatingPreference implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * preference id
     */
    private Long preferenceId;

    /**
     * user id
     */
    private Long userId;

    /**
     * user uid
     */
    private Long userUid;

    /**
     * ingredient id
     */
    private Long ingredientId;

    /**
     * seasoner id
     */
    private Long seasonerId;

    /**
     * true for like, false for dislike
     */
    private Boolean isLike;

    /**
     * true for allergy, false for not
     */
    private Boolean isAllergen;

    /**
     * reason why like or not
     */
    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Long getPreferenceId() {
        return preferenceId;
    }

    public void setPreferenceId(Long preferenceId) {
        this.preferenceId = preferenceId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserUid() {
        return userUid;
    }

    public void setUserUid(Long userUid) {
        this.userUid = userUid;
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

    public Boolean getIsLike() {
        return isLike;
    }

    public void setIsLike(Boolean isLike) {
        this.isLike = isLike;
    }

    public Boolean getIsAllergen() {
        return isAllergen;
    }

    public void setIsAllergen(Boolean isAllergen) {
        this.isAllergen = isAllergen;
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
        return "EatingPreference{" +
        "preferenceId = " + preferenceId +
        ", userId = " + userId +
        ", userUid = " + userUid +
        ", ingredientId = " + ingredientId +
        ", seasonerId = " + seasonerId +
        ", isLike = " + isLike +
        ", isAllergen = " + isAllergen +
        ", description = " + description +
        ", createdAt = " + createdAt +
        ", updatedAt = " + updatedAt +
        "}";
    }
}
