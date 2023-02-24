package com.group42.controller;

import com.group42.service.IIngredientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Guofeng Lin
 * @since 2023-02-10
 */
@RestController
@RequestMapping("/ingredient")
public class IngredientController extends BaseController{
    private final IIngredientService ingredientService;

    public IngredientController(IIngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }
}
