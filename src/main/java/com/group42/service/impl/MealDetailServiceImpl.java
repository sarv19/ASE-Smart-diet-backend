package com.group42.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group42.dao.MealDetailMapper;
import com.group42.model.bean.SuggestMealDetail;
import com.group42.model.entity.Meal;
import com.group42.model.entity.MealDetail;
import com.group42.model.vo.SummaryDetailVO;
import com.group42.service.IMealDetailService;
import com.group42.utils.CollectionUtils;
import com.group42.utils.ExceptionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Guofeng Lin
 * @since 2023-02-10
 */
@Service
public class MealDetailServiceImpl extends ServiceImpl<MealDetailMapper, MealDetail> implements IMealDetailService {

    @Override
    public List<SuggestMealDetail> getMealDetailByMealId(Long mealId) {
        List<SuggestMealDetail> suggestMealDetails = getBaseMapper().selectMealBaseTypeByMealId(mealId);
        return calcMealDetail(suggestMealDetails);
    }

    @Override
    public List<SuggestMealDetail> getSubstitutions(String userUid, Long mealId, Long ingredientId) {
        List<SuggestMealDetail> result = getBaseMapper().selectMealDetail(userUid, mealId, ingredientId);
        return calcMealDetail(result);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean confirmMealDetail(Meal meal, List<SuggestMealDetail> ingredients) {
        lambdaUpdate().eq(MealDetail::getMealId, meal.getMealId()).remove();
        List<MealDetail> mealDetails = new ArrayList<>(ingredients.size());
        for (SuggestMealDetail ingredient : ingredients) {
            MealDetail mealDetail = new MealDetail();
            mealDetail.setMealId(meal.getMealId()).setUserId(meal.getUserId()).setUserUid(meal.getUserUid());
            mealDetail.setIngredientId(ingredient.getIngredientId());
            mealDetail.setWeight(ingredient.getWeight()).setCalories(ingredient.getCalories());

            mealDetails.add(mealDetail);
        }
        if (saveBatch(mealDetails))
            return true;
        throw ExceptionUtils.newSE("Confirm meal detail failed");
    }

    @Override
    public List<SummaryDetailVO> selectSummaryDetail(List<Long> mealIds, String userUid) {
        if (CollectionUtils.isEmpty(mealIds)) return Collections.emptyList();
        return this.getBaseMapper().selectSummaryDetail(mealIds, 0);
    }

    private List<SuggestMealDetail> calcMealDetail(List<SuggestMealDetail> suggestMealDetails) {
        for (SuggestMealDetail type : suggestMealDetails) {
            type.setCalories(type.getTargetCaloriesMin() + ((type.getTargetCaloriesMax() - type.getTargetCaloriesMin()) >> 1));
            type.setWeight((int) (type.getCalories() * 1.0 / (type.getIngredientCalories()) * 100));
        }
        SuggestMealDetail[] target = suggestMealDetails.toArray(new SuggestMealDetail[0]);
        Arrays.sort(target, (o1, o2) -> (int) (o1.getTypeId() - o2.getTypeId()));
        return Arrays.stream(target).toList();
    }
}
