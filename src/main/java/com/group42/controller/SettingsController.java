package com.group42.controller;

import com.github.pagehelper.PageInfo;
import com.group42.model.bean.R;
import com.group42.model.entity.User;
import com.group42.model.entity.UserTarget;
import com.group42.model.to.EatingPerformanceTO;
import com.group42.model.to.UserSettingTO;
import com.group42.model.valid.Delete;
import com.group42.model.valid.Insert;
import com.group42.model.valid.Query;
import com.group42.model.valid.Update;
import com.group42.model.vo.UserVO;
import com.group42.service.IUserService;
import com.group42.service.IUserTargetService;
import com.group42.utils.*;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Guofeng Lin
 * @since 2023-03-10
 */
@RestController
@RequestMapping("/settings")
public class SettingsController extends BaseController {

    private final IUserService userService;
    private final IUserTargetService userTargetService;

    public SettingsController(IUserService userService, IUserTargetService userTargetService) {
        this.userService = userService;
        this.userTargetService = userTargetService;
    }

    @PostMapping("/queryDietPreference")
    public R queryDietPreference(@RequestBody @Validated(Query.class) EatingPerformanceTO to, HttpServletRequest request) {
        startPage(to);
        return R.ok(new PageInfo<>(
                        userTargetService.lambdaQuery()
                                .eq(UserTarget::getUserUid, JwtUtils.getUserUidFromRequest(request))
                                .orderByDesc(UserTarget::getIsActive)
                                .list()
                )
        );
    }

    @PostMapping("/addDietPreference")
    public R addDietPreference(@RequestBody @Validated(Insert.class) EatingPerformanceTO to, HttpServletRequest request) {
        UserTarget userTarget = initParam(to, UserTarget.class, UserTarget::getTargetId);
        String userUid = JwtUtils.getUserUidFromRequest(request);
        userTarget.setUserUid(userUid).setUserId(userService.findUserByUid(userUid).getUserId());
        userTarget = userTargetService.saveTarget(userTarget);
        if (ObjectUtils.isNotEmpty(userTarget))
            return R.ok(userTarget);
        return R.error();
    }

    @PostMapping("/editDietPreference")
    public R editDietPreference(@RequestBody @Validated(Update.class) EatingPerformanceTO to, HttpServletRequest request) {
        UserTarget userTarget = initParam(to, UserTarget.class, UserTarget::getTargetId);
        String userUid = JwtUtils.getUserUidFromRequest(request);
        userTarget.setUserUid(userUid).setUserId(userService.findUserByUid(userUid).getUserId());
        userTarget = userTargetService.updateTarget(userTarget.setTargetId(to.getTargetId()));
        if (ObjectUtils.isNotEmpty(userTarget))
            return R.ok(userTarget);
        return R.error();
    }

    @PostMapping("/deleteDietPreference")
    public R deleteDietPreference(@RequestBody @Validated(Delete.class) EatingPerformanceTO to) {
        UserTarget original = userTargetService.getById(to.getTargetId());
        if (original.getIsActive()) {
            return R.error("Cannot delete the active profile");
        }
        if (userTargetService.removeById(to.getTargetId()))
            return R.ok();
        return R.error();
    }


    @PostMapping("/querySettings")
    public R querySettings(@RequestBody UserSettingTO to, HttpServletRequest request) {
        UserVO vo = new UserVO();
        PojoUtils.copyProperties(userService.findUserByUid(JwtUtils.getUserUidFromRequest(request)), vo);
        return R.ok(vo);
    }

    @PostMapping("/editSettings")
    public R editSettings(@RequestBody @Validated(Update.class) UserSettingTO to, HttpServletRequest request) {
        String password = to.getPassword();
        if (StringUtils.isNotNull(password)) {
            if (StringUtils.lengthCheck(password, 3, 18)) {
                to.setPassword(AESUtil.encrypt(password));
            } else {
                return R.error("Nothing updated. Password length must be between 3 and 18");
            }
        } else if (CollectionUtils.isAllEmpty(to.getAddress(), to.getEmailAddress(), to.getGender(), to.getPhoneNumber(), to.getFullName())) {
            return R.ok();
        }
        String userUid = JwtUtils.getUserUidFromRequest(request);
        User user = initParam(to, User.class).setUserId(userService.findUserByUid(userUid).getUserId());
        user = userService.updatePersonalSetting(userUid, user);
        if (ObjectUtils.isNotEmpty(user))
            return R.ok(user);
        return R.error();
    }

    @PostMapping("/queryFoodPerformance")
    public R queryFoodPerformance(){
        return R.ok();
    }
    @PostMapping("/editFoodPerformance")
    public R editFoodPerformance(){
        return R.ok();
    }
    @PostMapping("/deleteFoodPerformance")
    public R deleteFoodPerformance(){
        return R.ok();
    }
    @PostMapping("/addFoodPerformance")
    public R addFoodPerformance(){
        return R.ok();
    }
}
