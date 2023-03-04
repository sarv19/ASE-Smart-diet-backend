package com.group42.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.group42.model.bean.SuggestIngredient;
import com.group42.model.entity.Ingredient;
import com.group42.model.entity.MealDetail;
import com.group42.model.vo.IngredientVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Guofeng Lin
 * @since 2023-02-10
 */
public interface IIngredientService extends IService<Ingredient> {
    List<IngredientVO> getIngredientsBySuggest(Long userId, Long mealId);
    List<SuggestIngredient> getAcceptableIngredients(Long userId);

    List<MealDetail> recommendByBaseType(Long userUid, Map<Long, MealDetail> detailMap);
}
