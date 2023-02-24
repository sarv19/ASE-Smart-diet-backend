package com.group42.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.group42.model.entity.User;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Guofeng Lin
 * @since 2023-02-10
 */
public interface IUserService extends IService<User> {
    User validateUser(String userId, String userUid);

}
