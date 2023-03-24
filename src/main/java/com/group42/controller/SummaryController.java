package com.group42.controller;

import com.group42.model.bean.R;
import com.group42.model.to.SummaryTO;
import com.group42.model.vo.SummaryVO;
import com.group42.service.IMealService;
import com.group42.service.IUserTargetService;
import com.group42.utils.CollectionUtils;
import com.group42.utils.JwtUtils;
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
@RequestMapping("/summary")
public class SummaryController extends BaseController {

    private final IMealService mealService;
    private final IUserTargetService userTargetService;

    public SummaryController(IMealService mealService, IUserTargetService userTargetService) {
        this.mealService = mealService;
        this.userTargetService = userTargetService;
    }

    @PostMapping("/summarizeToday")
    public R summarizeToday(@RequestBody SummaryTO to, HttpServletRequest request) {
        String userUid = JwtUtils.getUserUid(request);
        List<SummaryVO> data = mealService.summaryToday(userUid);
        Map<String, Object> result = CollectionUtils.newHashMap(2);
        result.put("summary", data);
        result.put("userTarget", userTargetService.findActiveTargetByUid(userUid));
        return R.ok(result);
    }

//    @PostMapping("/summarizeAMeal")
//    public R summarizeAMeal(@RequestBody @Validated(Query.class) SummaryTO to, HttpServletRequest request) {
//        Long mealId = to.getMealId();
//        return R.ok();
//    }

}
