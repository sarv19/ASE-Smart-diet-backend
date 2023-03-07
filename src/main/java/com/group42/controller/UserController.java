package com.group42.controller;

import com.github.pagehelper.PageInfo;
import com.group42.constant.ErrorEnum;
import com.group42.model.bean.R;
import com.group42.model.entity.User;
import com.group42.model.entity.UserTarget;
import com.group42.model.to.BaseTO;
import com.group42.model.to.EatingPerformanceTO;
import com.group42.model.to.UserSettingTO;
import com.group42.model.to.UserTO;
import com.group42.model.valid.Insert;
import com.group42.model.valid.Query;
import com.group42.model.valid.Update;
import com.group42.service.IUserService;
import com.group42.service.IUserTargetService;
import com.group42.utils.JwtUtils;
import com.group42.utils.PojoUtils;
import com.group42.utils.StringUtils;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping("/user")
public class UserController extends BaseController {

    private final IUserService userService;
    private final IUserTargetService userTargetService;

    public UserController(IUserService userService, IUserTargetService userTargetService) {
        this.userService = userService;
        this.userTargetService = userTargetService;
    }

    @PostMapping("/login")
    public R login(@RequestBody @Validated(Query.class) UserTO to) {
        User login = userService.login(to.getUsername(), to.getPassword());
        if (StringUtils.isNotNull(login))
            return R.ok("", login.getUserUid());
        return new R(ErrorEnum.FAIL_LOGIN);
    }

    @PostMapping("/register")
    public R register(@RequestBody @Validated(Insert.class) UserTO to) {
        if (userService.register(to.getUserUid(), to.getEmail()))
            return R.ok("", to.getUserUid());
        return R.error();
    }

    @PostMapping("/queryDietPreference")
    public R queryDietPreference(@RequestBody @Validated(Query.class) EatingPerformanceTO to, HttpServletRequest request) {
        startPage(to);
        return R.ok(new PageInfo<>(userTargetService.lambdaQuery()
                .eq(UserTarget::getUserUid, JwtUtils.getUserUidFromRequest(request)).list()));
    }
    @PostMapping("/addDietPreference")
    public R addDietPreference(@RequestBody @Validated(Insert.class) EatingPerformanceTO to, HttpServletRequest request) {
        startPage(to);
        return R.ok(new PageInfo<>(userTargetService.lambdaQuery()
                .eq(UserTarget::getUserUid, JwtUtils.getUserUidFromRequest(request)).list()));
    }

    @PostMapping("/editDietPreference")
    public R editDietPreference(@RequestBody @Validated(Update.class) EatingPerformanceTO to, HttpServletRequest request) {
        UserTarget userTarget = new UserTarget();
        PojoUtils.copyProperties(to, userTarget);
        if (userTargetService.updateUserTarget(userTarget.setUserUid(JwtUtils.getUserUidFromRequest(request))))
            return R.ok();
        return R.error();
    }
    @PostMapping("/deleteDietPreference")
    public R deleteDietPreference(@RequestBody @Validated(Update.class) EatingPerformanceTO to, HttpServletRequest request) {
        UserTarget userTarget = new UserTarget();
        PojoUtils.copyProperties(to, userTarget);
        if (userTargetService.updateUserTarget(userTarget.setUserUid(JwtUtils.getUserUidFromRequest(request))))
            return R.ok();
        return R.error();
    }

    @PostMapping("/querySettings")
    public R querySettings(@RequestBody @Validated(Query.class) UserSettingTO to) {
        return R.ok();
    }

    @PostMapping("/editSettings")
    public R editSettings(@RequestBody @Validated(Update.class) UserSettingTO to) {
        return R.ok();
    }

    @PostMapping("/query")
    public R query(@RequestBody BaseTO to) {
        startPage(to);
        return R.ok(new PageInfo<>(userService.list()));
    }

}
