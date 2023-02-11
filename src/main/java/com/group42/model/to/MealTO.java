package com.group42.model.to;

import com.group42.model.valid.Info;
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
public class MealTO extends BaseTO{
    @NotNull(groups = {Query.class, Update.class})
    private Long userId;
    @NotNull(groups = {Info.class})
    private Long mealId;
    @NotNull(groups = {Info.class})
    private Long ingredientId;
    private String mealType;
    private String mealDate;

}
