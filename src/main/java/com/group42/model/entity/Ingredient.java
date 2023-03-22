package com.group42.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Ingredient extends BaseEntity {

    /**
     * ingredient Id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long ingredientId;

    private Long typeId;

    private String ingredientName;

    /**
     * english name/precise information about the ingredient
     */
    private String description;

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

}
