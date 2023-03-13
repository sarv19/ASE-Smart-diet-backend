package com.group42.model.to;

import com.group42.model.bean.SuggestMealDetail;
import com.group42.model.valid.Info;
import com.group42.model.valid.Insert;
import com.group42.model.valid.Query;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * MealTO
 *
 * @author Guofeng Lin
 * @since 2023/2/10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MealTO extends BaseTO {
//    @NotNull(groups = {Query.class, Update.class, Insert.class})
//    private Long userId;
    @NotNull(groups = {Info.class, Insert.class})
    private Long mealId;
    @NotNull(groups = {Info.class})
    private Long ingredientId;
    @NotNull(groups = {Query.class})
    private String mealType;
    private String mealDate;
    @NotNull(groups = {Insert.class})
    @Size(min = 0, max = 1000, groups = {Insert.class})
    private List<SuggestMealDetail> ingredients;

}
