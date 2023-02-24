package com.group42.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group42.dao.UserMapper;
import com.group42.model.entity.User;
import com.group42.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Guofeng Lin
 * @since 2023-02-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User validateUser(String userId, String userUid) {
        return new User().setUserName("test").setPassword("test");
    }
}
