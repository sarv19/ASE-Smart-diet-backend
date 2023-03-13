package com.group42.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.group42.model.entity.User;

/**
 *
 * @author Guofeng Lin
 * @since 2023-02-10
 */
public interface IUserService extends IService<User> {
    boolean register(String userUid, String email);

    User login(String username, String password);

    User findUserByUid(String userUid);

    User updatePersonalSetting(String userUid, User user);
}
