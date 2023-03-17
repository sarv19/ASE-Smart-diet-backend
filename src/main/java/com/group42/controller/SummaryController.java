package com.group42.controller;

import com.group42.model.bean.R;
import com.group42.model.to.SummaryTO;
import com.group42.service.IMealService;
import com.group42.utils.JwtUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Guofeng Lin
 * @since 2023-02-10
 */
@RestController
@RequestMapping("/summary")
public class SummaryController extends BaseController {

    private final IMealService mealService;

    public SummaryController(IMealService mealService) {
        this.mealService = mealService;
    }

    @PostMapping("/summarizeToday")
    public R summarizeToday(@RequestBody SummaryTO to, HttpServletRequest request) {
        return R.ok(mealService.summaryToday(JwtUtils.getUserUidFromRequest(request)));
    }

//    @PostMapping("/summarizeAMeal")
//    public R summarizeAMeal(@RequestBody @Validated(Query.class) SummaryTO to, HttpServletRequest request) {
//        Long mealId = to.getMealId();
//        return R.ok();
//    }

}
