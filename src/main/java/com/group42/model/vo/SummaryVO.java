package com.group42.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * SummaryVO
 *
 * @author Guofeng Lin
 * @since 2023/3/16
 */
@Data
@Accessors(chain = true)
public class SummaryVO {
    private Long mealId;
    private SummaryMealVO meal;
    private List<SummaryDetailVO> ingredients;
}
