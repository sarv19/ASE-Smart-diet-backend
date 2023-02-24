package com.group42.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group42.dao.UserMapper;
import com.group42.model.entity.User;
import com.group42.service.IUserService;
import com.group42.utils.AESUtil;
import com.group42.utils.StringUtils;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

/**
 * @author Guofeng Lin
 * @since 2023-02-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public boolean register(String userUid, String email) {
        User user = new User();
        String userName = email.split("@")[0];
        user.setUserUid(userUid).setEmailAddress(email).setPassword("").setUserName(userName)
                .setFullName(userName).setTargetCaloriesMax(0).setTargetCaloriesMin(0);
        return save(user);
    }

    @Override
    public User login(@NotNull String username, @NotNull String password) {
        User user = lambdaQuery().eq(User::getUserName, username).one();
        if (StringUtils.isNotNull(user)) {
            String decrypt = AESUtil.decrypt(user.getPassword());
            if (password.equals(decrypt))
                return user;
        }
        return null;
    }

    @Override
    public User validateUser(String userUid) {
        if (StringUtils.isEmpty(userUid))
            return null;
        userUid = userUid.replace("Bearer ", "").trim();
        return lambdaQuery().eq(User::getUserUid, userUid).one();
    }
}
