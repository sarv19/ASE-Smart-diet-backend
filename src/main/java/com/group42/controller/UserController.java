package com.group42.controller;

import com.github.pagehelper.PageInfo;
import com.group42.model.base.R;
import com.group42.model.to.BaseTO;
import com.group42.service.IUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Guofeng Lin
 * @since 2023-02-10
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public R login() {
        return R.ok();
    }

    @PostMapping("/query")
    public R query(@RequestBody BaseTO to) {
        startPage(to);
        return R.ok(new PageInfo<>(userService.list()));
    }

}
