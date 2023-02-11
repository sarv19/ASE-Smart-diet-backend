package com.group42.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.group42.model.entity.IngredientType;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Guofeng Lin
 * @since 2023-02-11
 */
public interface IIngredientTypeService extends IService<IngredientType> {
    List<IngredientType> getAcceptableBaseType(Long userId);
}
