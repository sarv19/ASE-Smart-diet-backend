package com.group42.controller;

import com.github.pagehelper.PageInfo;
import com.group42.model.bean.R;
import com.group42.model.to.UserTO;
import com.group42.service.IIngredientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Guofeng Lin
 * @since 2023-02-10
 */
@RestController
@RequestMapping("/ingredient")
public class IngredientController extends BaseController {

    private final IIngredientService ingredientService;

    public IngredientController(IIngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping("/ingredientList")
    public R ingredientList(@RequestBody UserTO to) {
        startPage(to);
        return R.ok(new PageInfo<>(ingredientService.lambdaQuery().list()));
    }


}
