package com.group42.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.group42.model.entity.Ingredient;
import com.group42.model.entity.MealDetail;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Guofeng Lin
 * @since 2023-02-10
 */
public interface IIngredientService extends IService<Ingredient> {

    List<MealDetail> recommendByBaseType(Long userUid, Map<Long, MealDetail> detailMap);
}
