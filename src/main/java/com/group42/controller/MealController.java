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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
        String userUid = JwtUtils.getUserUid(request);
        Meal todayMeal = mealService.getTodayMeal(userUid, to.getMealType());

        Map<String, Object> response = new HashMap<>();
        if (ObjectUtils.isNotEmpty(todayMeal)) {
            response.put("mealDate", todayMeal.getMealDate());
            response.put("totalCalories", todayMeal.getTotalCalories());
            response.put("totalWeight", todayMeal.getTotalWeight());
            response.put("mealType", todayMeal.getMealType());
        } else {
            response.put("mealDate", null);
            if (ObjectUtils.isEmpty(mealId)) { // first time to query a meal
                todayMeal = Optional.
                        ofNullable(mealService.InitMeal(userUid, to.getMealType())).
                        orElse(mealService.getTodayMeal(userUid, to.getMealType()));
            }
        }
        mealId = todayMeal.getMealId();
        response.put("mealId", mealId);

        startPage(to);
        Map<String, Object> map = PageUtils.pageInfoMap(mealDetailService.getMealDetailByMealId(mealId));
        map.putAll(response);
        return R.ok(map);
    }

    @PostMapping("/querySubstitutions")
    public R querySubstitutions(@RequestBody @Validated({Info.class}) MealTO to, HttpServletRequest request) {
        to.setPageSize(5); // only need 5 ingredients
        to.setPageNum(1); // only query the first page
        startPage(to);
        return R.ok(PageUtils.pageInfoMap(
                mealDetailService.getSubstitutions(JwtUtils.getUserUid(request), to.getMealId(), to.getIngredientId())
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

    @PostMapping("/mealHistory")
    @Transactional(rollbackFor = Exception.class)
    public R mealHistory(@RequestBody MealTO to, HttpServletRequest request) {
        String uid = JwtUtils.getUserUid(request);
        startPage(to);
        return R.ok(PageUtils.page(mealService.queryMealHistory(uid)));
    }

    @PostMapping("/clearHistory")
    public R clearHistory(@RequestBody MealTO to, HttpServletRequest request) {
        return R.ok(mealService.clearAllMeal(JwtUtils.getUserUid(request)));
    }
}
