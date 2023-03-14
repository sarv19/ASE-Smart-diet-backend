package com.group42.controller;

import com.group42.service.IUserService;
import com.group42.service.IUserTargetService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Guofeng Lin
 * @since 2023-02-10
 */
@RestController
@RequestMapping("/summary")
public class SummaryController extends BaseController {

    private final IUserService userService;
    private final IUserTargetService userTargetService;

    public SummaryController(IUserService userService, IUserTargetService userTargetService) {
        this.userService = userService;
        this.userTargetService = userTargetService;
    }


}
