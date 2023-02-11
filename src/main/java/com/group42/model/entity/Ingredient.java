package com.group42.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

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
@TableName("ingredient")
@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Ingredient implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ingredient Id
     */
    private Long ingredientId;

    private String ingredientName;

    /**
     * english name/precise information about the ingredient
     */
    private String description;

    /**
     * mg/1000g
     */
    private Integer calories;

    /**
     * mg/1000g
     */
    private Integer fat;

    /**
     * mg/1000g
     */
    private Integer carbohydrate;

    /**
     * mg/1000g
     */
    private Integer protein;

    /**
     * mg/1000g
     */
    private Integer sodium;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
