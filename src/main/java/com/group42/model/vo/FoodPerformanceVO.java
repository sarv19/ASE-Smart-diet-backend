package com.group42.model.vo;

import com.group42.model.entity.Ingredient;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * FoodPerformanceVO
 *
 * @author Guofeng Lin
 * @since 2023/3/23
 */
@Getter
@ToString
public class FoodPerformanceVO {
    private final List<Ingredient> preferred;
    private final List<Ingredient> unwanted;
    private final List<Ingredient> allergens;

    public FoodPerformanceVO() {
        this.preferred = new ArrayList<>();
        this.unwanted = new ArrayList<>();
        this.allergens = new ArrayList<>();
    }
}
