package com.group42.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group42.dao.UserTargetMapper;
import com.group42.model.entity.UserTarget;
import com.group42.service.IUserTargetService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Guofeng Lin
 * @since 2023-03-06
 */
@Service
public class UserTargetServiceImpl extends ServiceImpl<UserTargetMapper, UserTarget> implements IUserTargetService {

    @Override
    public UserTarget saveTarget(UserTarget userTarget) {
        if (inactiveTarget(userTarget)) {
            save(userTarget.setIsActive(true));
            return userTarget;
        }
        return null;
    }

    @Override
    public UserTarget updateTarget(UserTarget userTarget) {
        if (inactiveTarget(userTarget)) {
            updateById(userTarget.setIsActive(true));
            return userTarget;
        }
        return null;
    }

    @Override
    public UserTarget findActiveTargetByUid(String userUid) {
        return lambdaQuery().eq(UserTarget::getUserUid, userUid).eq(UserTarget::getIsActive, true).last("limit 1").one();
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean inactiveTarget(UserTarget userTarget) {
        Assert.notNull(userTarget.getUserId(), "userId cannot be null");
        Assert.notNull(userTarget.getUserUid(), "userUid cannot be null");
        return lambdaUpdate().eq(UserTarget::getUserId, userTarget.getUserId()).eq(UserTarget::getIsActive, true)
                .set(UserTarget::getIsActive, false).update();
    }
}
