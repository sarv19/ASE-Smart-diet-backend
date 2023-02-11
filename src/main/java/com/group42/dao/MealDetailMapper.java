package com.group42.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group42.model.bean.SuggestBaseType;
import com.group42.model.entity.MealDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Guofeng Lin
 * @since 2023-02-10
 */
public interface MealDetailMapper extends BaseMapper<MealDetail> {
    List<SuggestBaseType> selectMealBaseTypeByMealId(@Param("mealId") Long mealId);
}
