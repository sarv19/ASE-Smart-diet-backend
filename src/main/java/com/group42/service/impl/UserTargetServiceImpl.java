package com.group42.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group42.dao.UserTargetMapper;
import com.group42.model.entity.UserTarget;
import com.group42.service.IUserTargetService;
import org.springframework.stereotype.Service;

/**
 * @author Guofeng Lin
 * @since 2023-03-06
 */
@Service
public class UserTargetServiceImpl extends ServiceImpl<UserTargetMapper, UserTarget> implements IUserTargetService {

    @Override
    public boolean updateUserTarget(UserTarget userTarget) {
        return saveOrUpdate(userTarget);
    }
}
