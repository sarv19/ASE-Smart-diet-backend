package com.group42.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group42.dao.EatingPreferenceMapper;
import com.group42.model.entity.EatingPreference;
import com.group42.model.entity.Ingredient;
import com.group42.model.entity.User;
import com.group42.model.to.FoodPerformanceTO;
import com.group42.model.vo.FoodPerformanceVO;
import com.group42.service.IEatingPreferenceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * EatingPreferenceServiceImpl
 *
 * @author Guofeng Lin
 * @since 2023/3/23
 */
@Service
public class EatingPreferenceServiceImpl extends ServiceImpl<EatingPreferenceMapper, EatingPreference> implements IEatingPreferenceService {
    @Override
    public FoodPerformanceVO queryFoodPerformance(Long userId) {
        List<EatingPreference> eatingPreferences = this.getBaseMapper().selectByUserId(userId);
        FoodPerformanceVO result = new FoodPerformanceVO();
        for (EatingPreference now : eatingPreferences) {
            Ingredient ingredient = initIngredient(now);
            if (now.getIsAllergen()) {
                result.getAllergens().add(ingredient);
            } else if (now.getIsLike()) {
                result.getPreferred().add(ingredient);
            } else {
                result.getUnwanted().add(ingredient);
            }
        }
        return result;
    }

    @Override
    public boolean addFoodPerformance(FoodPerformanceTO to, User user) {
        EatingPreference eatingPreference = Optional.ofNullable(
                        lambdaQuery()
                                .eq(EatingPreference::getUserUid, user.getUserUid())
                                .eq(EatingPreference::getIngredientId, to.getIngredientId())
                                .one())
                .orElse(new EatingPreference());
        eatingPreference.setUserId(user.getUserId()).setUserUid(user.getUserUid());
        eatingPreference.setIsLike(to.getRecommendLevel() > 0);
        eatingPreference.setIsAllergen(to.getRecommendLevel() < 0);
        return saveOrUpdate(eatingPreference.setIngredientId(to.getIngredientId()));
    }

    private Ingredient initIngredient(EatingPreference eatingPreference) {
        Ingredient result = new Ingredient();
        result.setPreferenceId(eatingPreference.getPreferenceId());
        result.setIngredientId(eatingPreference.getIngredientId());
        result.setIngredientName(eatingPreference.getIngredientName());
        return result;
    }
}
