package com.group42.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group42.model.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Guofeng Lin
 * @since 2023-02-10
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    Boolean insertIgnore(@Param("user") User user);
}
