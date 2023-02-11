package com.group42.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Guofeng Lin
 * @since 2023-02-10
 */
@TableName(value = "meal")
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Meal extends BaseEntity {

    /**
     * mealId
     */
    @TableId(type = IdType.ASSIGN_UUID)
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
}
