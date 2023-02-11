package com.group42.model.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * SuggestBaseType
 *
 * @author Guofeng Lin
 * @since 2023/2/11
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuggestBaseType {
    private Long ingredientId;
    private String ingredientName;
    private String description;
    private Integer calories;
    private Integer weight;

}
