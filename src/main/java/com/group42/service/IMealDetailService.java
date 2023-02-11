package com.group42.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.group42.model.bean.SuggestBaseType;
import com.group42.model.entity.MealDetail;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Guofeng Lin
 * @since 2023-02-10
 */
public interface IMealDetailService extends IService<MealDetail> {
    List<SuggestBaseType> getMealBaseTypeByMealId(Long mealId);
}
