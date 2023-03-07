package com.group42.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author Guofeng Lin
 * @since 2023-03-06
 */
@TableName("user_target")
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserTarget extends BaseEntity {

    /**
     * target Id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long targetId;

    /**
     * user Id
     */
    private Long userId;

    /**
     * user unique id from Google, Facebook, etc.
     */
    private String userUid;
    private Boolean isActive;

    private Integer targetCaloriesMin;

    private Integer targetCaloriesMax;

    private Integer targetProteinMin;

    private Integer targetProteinMax;

    private Integer targetCarbohydrateMax;

    private Integer targetCarbohydrateMin;

    private Integer targetFatMin;

    private Integer targetFatMax;

    private Integer targetMineralsMin;

    private Integer targetMineralsMax;
}
