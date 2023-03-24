package com.group42.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.group42.model.entity.EatingPreference;
import com.group42.model.entity.User;
import com.group42.model.to.FoodPerformanceTO;
import com.group42.model.vo.FoodPerformanceVO;

/**
 *
 * @author Guofeng Lin
 * @since 2023-02-27
 */
public interface IEatingPreferenceService extends IService<EatingPreference> {
    FoodPerformanceVO queryFoodPerformance(Long userId);

    boolean addFoodPerformance(FoodPerformanceTO to, User user);
}
