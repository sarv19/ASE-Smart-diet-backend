package com.group42.model.to;

import com.group42.model.valid.Query;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * SummaryTO
 *
 * @author Guofeng Lin
 * @since 2023/3/16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SummaryTO extends BaseTO{
    @NotNull(groups = Query.class)
    Long mealId;

    Integer dayBefore;
}
