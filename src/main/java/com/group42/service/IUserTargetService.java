package com.group42.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.group42.model.entity.UserTarget;


/**
 * @author Guofeng Lin
 * @since 2023-03-06
 */
public interface IUserTargetService extends IService<UserTarget> {

    UserTarget saveTarget(UserTarget userTarget);
    UserTarget updateTarget(UserTarget userTarget);

    UserTarget findActiveTargetByUid(String userUid);

}
