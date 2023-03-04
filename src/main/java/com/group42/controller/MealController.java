package com.group42.controller;

import com.group42.model.bean.R;
import com.group42.model.bean.SuggestMealDetail;
import com.group42.model.entity.Meal;
import com.group42.model.to.MealTO;
import com.group42.model.valid.Info;
import com.group42.model.valid.Insert;
import com.group42.model.valid.Query;
import com.group42.service.IMealDetailService;
import com.group42.service.IMealService;
import com.group42.utils.ExceptionUtils;
import com.group42.utils.JwtUtils;
import com.group42.utils.PageUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author Guofeng Lin
 * @since 2023-02-10
 */
@RestController
@RequestMapping("/meal")
public class MealController extends BaseController {
    private final IMealService mealService;
    private final IMealDetailService mealDetailService;

    public MealController(IMealService mealService, IMealDetailService mealDetailService) {
        this.mealService = mealService;
        this.mealDetailService = mealDetailService;
    }

    @PostMapping("/queryAMeal")
    public R queryAMeal(@RequestBody @Validated({Query.class}) MealTO to, HttpServletRequest request) {
        Long mealId = to.getMealId();
        if (ObjectUtils.isEmpty(mealId)) { // first time to query a meal
            if (ObjectUtils.isEmpty(to.getMealType())) {
                return R.error("meal type cannot be null while meal id is null");
            }
            mealId = mealService.recommandMeal(JwtUtils.getUserUidFromRequest(request), to.getMealType()).getMealId();
        }
        startPage(to);
        Map<String, Object> map = PageUtils.pageInfoMap(mealDetailService.getMealDetailByMealId(mealId));
        map.put("mealId", mealId);
        return R.ok(map);
    }

    @PostMapping("/mealForToday")
    public R mealForToday(@RequestBody @Validated({Query.class}) MealTO to) {
        return R.ok();
    }

    @PostMapping("/querySubstitutions")
    public R querySubstitutions(@RequestBody @Validated({Info.class}) MealTO to, HttpServletRequest request) {
        startPage(to);
        return R.ok(PageUtils.pageInfoMap(
                mealDetailService.getSubstitutions(JwtUtils.getUserUidFromRequest(request), to.getMealId(), to.getIngredientId())
        ));
    }

    @PostMapping("/confirmAMeal")
    @Transactional(rollbackFor = Exception.class)
    public R confirmAMeal(@RequestBody @Validated({Insert.class}) MealTO to) {
        int totalCalories = 0;
        int totalWeight = 0;
        List<SuggestMealDetail> ingredients = to.getIngredients();
        for (SuggestMealDetail ingredient : ingredients) {
            totalCalories += ingredient.getCalories();
            totalWeight += ingredient.getWeight();
        }
        Long mealId = to.getMealId();
        Meal meal = mealService.confirmMeal(mealId, totalCalories, totalWeight);
        if (ObjectUtils.isNotEmpty(meal) && mealDetailService.confirmMealDetail(meal, ingredients))
            return R.ok();
        throw ExceptionUtils.newSE("confirm meal failed");
    }
}
