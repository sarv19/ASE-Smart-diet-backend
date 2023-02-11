package com.group42.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.group42.model.entity.Ingredient;
import com.group42.model.vo.IngredientVO;

import java.util.List;

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
}
