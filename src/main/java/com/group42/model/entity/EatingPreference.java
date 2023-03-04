package com.group42.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 *
 * @author Guofeng Lin
 * @since 2023-02-27
 */

@TableName("eating_preference")
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EatingPreference extends BaseEntity {

    /**
     * preference id
     */
    @TableId(type = IdType.ASSIGN_ID)
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
}
