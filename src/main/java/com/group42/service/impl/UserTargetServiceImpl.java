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
    public UserTarget saveOrUpdateTarget(UserTarget userTarget) {
        if (activeATarget(userTarget))
            return userTarget;
        return null;
    }

    @Override
    public UserTarget findActiveTargetByUid(String userUid) {
        return lambdaQuery().eq(UserTarget::getUserUid, userUid).eq(UserTarget::getIsActive, true).one();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean activeATarget(UserTarget userTarget) {
        Assert.notNull(userTarget.getUserId(),"userId cannot be null");
        Assert.notNull(userTarget.getUserUid(),"userUid cannot be null");
        boolean updated = lambdaUpdate().eq(UserTarget::getUserId, userTarget.getUserId()).eq(UserTarget::getIsActive, true)
                .set(UserTarget::getIsActive, false).update();
        if (updated) {
            updated = saveOrUpdate(userTarget.setIsActive(true));
        }
        return updated;
    }
}
