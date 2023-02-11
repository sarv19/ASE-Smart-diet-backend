package com.group42.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group42.dao.IngredientTypeMapper;
import com.group42.model.entity.IngredientType;
import com.group42.service.IIngredientTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Guofeng Lin
 * @since 2023-02-11
 */
@Service
public class IngredientTypeServiceImpl extends ServiceImpl<IngredientTypeMapper, IngredientType> implements IIngredientTypeService {

    @Override
    public List<IngredientType> getAcceptableBaseType(Long userId) {
        return getBaseMapper().selectAcceptableBaseType(userId);
    }
}
