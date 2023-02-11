package com.group42.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group42.dao.MealDetailMapper;
import com.group42.model.bean.SuggestBaseType;
import com.group42.model.entity.MealDetail;
import com.group42.service.IMealDetailService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Guofeng Lin
 * @since 2023-02-10
 */
@Service
public class RecipeDetailServiceImpl extends ServiceImpl<MealDetailMapper, MealDetail> implements IMealDetailService {

    @Override
    public List<SuggestBaseType> getMealBaseTypeByMealId(Long mealId) {
        return getBaseMapper().selectMealBaseTypeByMealId(mealId);
    }
}
