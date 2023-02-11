package com.group42.model.to;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.group42.model.valid.Query;
import com.group42.model.valid.Update;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * MealTO
 *
 * @author Guofeng Lin
 * @since 2023/2/10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MealTO extends BaseTO{
    @NotNull(groups = {Query.class, Update.class})
    private Long userId;
    private Long mealId;
    private String mealType;
    private String mealDate;

}
