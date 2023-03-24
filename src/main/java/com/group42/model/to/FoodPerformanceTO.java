package com.group42.model.to;

import com.group42.model.valid.Delete;
import com.group42.model.valid.Insert;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;


/**
 * FoodPerformanceTO
 *
 * @author Guofeng Lin
 * @since 2023/3/23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class FoodPerformanceTO extends BaseTO {
    @NotNull(groups = {Delete.class})
    private String preferenceId;
    @NotNull(groups = {Insert.class})
    private Long ingredientId;

    @NotNull(groups = {Insert.class})
    @Range(min = -1, max = 1)
    private Integer recommendLevel;

}
