package com.group42.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.group42.model.bean.SuggestMealDetail;
import com.group42.model.entity.Meal;
import com.group42.model.entity.MealDetail;
import com.group42.model.vo.SummaryDetailVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Guofeng Lin
 * @since 2023-02-10
 */
public interface IMealDetailService extends IService<MealDetail> {
    List<SuggestMealDetail> getMealDetailByMealId(Long mealId);
    List<SuggestMealDetail> getSubstitutions(String userUid, Long mealId, Long ingredientId);
    boolean confirmMealDetail(Meal meal, List<SuggestMealDetail> ingredients);
    List<SummaryDetailVO> selectSummaryDetail(@Param("mealIds") List<Long> mealIds, String userUid);

}
