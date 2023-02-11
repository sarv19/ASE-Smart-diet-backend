package com.group42.controller;

import com.group42.model.base.R;
import com.group42.model.to.MealTO;
import com.group42.model.valid.Query;
import com.group42.service.IIngredientService;
import com.group42.service.IMealService;
import com.group42.utils.PageUtils;
import com.group42.utils.SeqUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.group42.utils.PageUtils.startPage;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Guofeng Lin
 * @since 2023-02-10
 */
@RestController
@RequestMapping("/meal")
public class MealController {
    private final IMealService mealService;
    private final IIngredientService ingredientService;

    public MealController(IMealService mealService, IIngredientService ingredientService) {
        this.mealService = mealService;
        this.ingredientService = ingredientService;
    }

    @PostMapping("/queryAMeal")
    public R queryAMeal(@RequestBody @Validated({Query.class}) MealTO to) {
        startPage(to);
        Map<String, Object> map = PageUtils.pageInfoMap(ingredientService.getIngredientsBySuggest(to.getUserId()));
        map.put("mealId", SeqUtils.getId());
        return R.ok(map);
    }
}
