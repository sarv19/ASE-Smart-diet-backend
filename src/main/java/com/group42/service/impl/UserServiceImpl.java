package com.group42.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group42.constant.DefaultValue;
import com.group42.dao.UserMapper;
import com.group42.model.entity.User;
import com.group42.model.entity.UserTarget;
import com.group42.service.IUserService;
import com.group42.service.IUserTargetService;
import com.group42.utils.AESUtil;
import com.group42.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Guofeng Lin
 * @since 2023-02-10
 */
@Service
@EnableCaching
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    private final IUserTargetService userTargetService;

    public UserServiceImpl(IUserTargetService userTargetService) {
        this.userTargetService = userTargetService;
    }

    @Override
    @CacheEvict(value = "cacheById", key = "#userUid", beforeInvocation = true)
    @Transactional(rollbackFor = Exception.class)
    public boolean register(String userUid, String email) {
        List<User> users = lambdaQuery().eq(User::getUserUid, userUid).list();
        if (ObjectUtils.isNotEmpty(users)) {
            log.info("Found " + users.size() + "user(s) for " + userUid);
            return true;
        }
        String userName = email.split("@")[0];
        User user = new User().setUserUid(userUid).setEmailAddress(email)
                .setPassword("").setUserName(userName).setFullName(userName);
        log.info("user register successfully: " + user);
        return save(user) && userTargetService.save(
                new UserTarget()
                        .setUserId(user.getUserId()).setUserUid(userUid).setIsActive(true)
                        .setTargetCaloriesMax(DefaultValue.DEFAULT_MAX_CALORIES).setTargetCaloriesMin(DefaultValue.DEFAULT_MIN_CALORIES));
    }

    @Override
    public User login(@NotNull String username, @NotNull String password) {
        List<User> user = lambdaQuery().eq(User::getUserName, username).list();
        if (StringUtils.isNotNull(user)) {
            for (User u : user) {
                if (password.equals(AESUtil.decrypt(u.getPassword())))
                    return u;
            }
        }
        return null;
    }

    @Override
    @Nullable
    @Cacheable(value = "users", key = "#userUid", unless = "#result == null")
    public User findUserByUid(String userUid) {
        if (StringUtils.isEmpty(userUid))
            return null;
        return lambdaQuery().eq(User::getUserUid, userUid).one();
    }

}
