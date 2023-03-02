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
public class Seasoner implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * seasoner id
     */
    private Long seasonerId;

    private String seasonerName;

    /**
     * english name/precise information about the seasoner
     */
    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Long getSeasonerId() {
        return seasonerId;
    }

    public void setSeasonerId(Long seasonerId) {
        this.seasonerId = seasonerId;
    }

    public String getSeasonerName() {
        return seasonerName;
    }

    public void setSeasonerName(String seasonerName) {
        this.seasonerName = seasonerName;
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
        return "Seasoner{" +
        "seasonerId = " + seasonerId +
        ", seasonerName = " + seasonerName +
        ", description = " + description +
        ", createdAt = " + createdAt +
        ", updatedAt = " + updatedAt +
        "}";
    }
}
