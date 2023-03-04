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
@TableName("seasoner")
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Seasoner extends BaseEntity {

    /**
     * seasoner id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long seasonerId;

    private String seasonerName;

    /**
     * english name/precise information about the seasoner
     */
    private String description;

}
