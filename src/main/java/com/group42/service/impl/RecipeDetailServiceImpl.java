package com.group42.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group42.dao.RecipeDetailMapper;
import com.group42.model.entity.RecipeDetail;
import com.group42.service.IRecipeDetailService;
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
public class RecipeDetailServiceImpl extends ServiceImpl<RecipeDetailMapper, RecipeDetail> implements IRecipeDetailService {

}
