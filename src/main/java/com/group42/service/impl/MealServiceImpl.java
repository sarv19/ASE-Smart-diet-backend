package com.group42.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group42.constant.SuggestStrategy;
import com.group42.dao.MealMapper;
import com.group42.model.entity.IngredientType;
import com.group42.model.entity.Meal;
import com.group42.model.entity.MealDetail;
import com.group42.model.entity.UserTarget;
import com.group42.model.vo.SummaryDetailVO;
import com.group42.model.vo.SummaryMealVO;
import com.group42.model.vo.SummaryVO;
import com.group42.service.*;
import com.group42.utils.CollectionUtils;
import com.group42.utils.ExceptionUtils;
import com.group42.utils.SeqUtils;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Guofeng Lin
 * @since 2023-02-10
 */
@Service
public class MealServiceImpl extends ServiceImpl<MealMapper, Meal> implements IMealService {
    private final IIngredientTypeService ingredientTypeService;
    private final IIngredientService ingredientService;
    private final IMealDetailService mealDetailService;
    private final IUserTargetService userTargetService;

    public MealServiceImpl(
            IIngredientTypeService ingredientTypeService,
            IIngredientService ingredientService,
            IMealDetailService mealDetailService,
            IUserTargetService userTargetService
    ) {
        this.ingredientTypeService = ingredientTypeService;
        this.ingredientService = ingredientService;
        this.mealDetailService = mealDetailService;
        this.userTargetService = userTargetService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @Nullable
    public Meal InitMeal(String userUid, String mealType) {
        UserTarget userTarget = userTargetService.findActiveTargetByUid(userUid);
        Meal meal = new Meal().setMealId(SeqUtils.getId());
        meal.setUserId(userTarget.getUserId()).setUserUid(userUid);
        meal.setMealType(mealType);
        Integer max = userTarget.getTargetCaloriesMax();
        Integer min = userTarget.getTargetCaloriesMin();
        if (max == null || min == null) {
            throw ExceptionUtils.newSE("User: " + userTarget.getUserId() + " has not set target calories");
        }
        if (max < 1 || min < 1) {
            throw ExceptionUtils.newSE("User: " + userTarget.getUserId() + " has set target calories incorrectly");
        }
        if (max < min) { // swap values
            max ^= min;
            min ^= max;
            max ^= min;
        }
        Integer proportion = SuggestStrategy.getProportionByMealType(meal.getMealType());
        max = max * proportion / 100;
        min = min * proportion / 100;
        // if fail to save a meal at this time, means that it is saved before
        if (getBaseMapper().insertIgnore(meal.setTotalWeight(min).setTotalCalories(max)) && prepareRecommend(meal)) {
            return meal;
        }
        return null;
    }

    @Override
    public Meal getTodayMeal(String userUid, String mealType) {
        return getBaseMapper().findTodayMealByUserUid(userUid, mealType);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Meal confirmMeal(Long mealId, int totalCalories, int totalWeight) {
        Meal one = Optional.ofNullable(lambdaQuery().eq(Meal::getMealId, mealId).isNull(Meal::getMealDate).one())
                .orElseThrow(() -> ExceptionUtils.newSE("Meal: " + mealId + " has been confirmed before"));
        lambdaUpdate().eq(Meal::getMealId, mealId)
                .set(Meal::getTotalCalories, totalCalories)
                .set(Meal::getTotalWeight, totalWeight)
                .set(Meal::getMealDate, new Date())
                .update();
        return one;
    }

    @Override
    public List<Meal> queryMealHistory(String userUid) {
        return lambdaQuery().eq(Meal::getUserUid, userUid).isNotNull(Meal::getMealDate)
                .orderByDesc(Meal::getCreatedAt).list();
    }

    @Override
    public List<SummaryVO> summaryToday(String userUid) {
        List<SummaryMealVO> summaryMealVOS = this.getBaseMapper().selectSummaryMeal(userUid, 0);
        Map<Long, SummaryVO> summaryResultMap = CollectionUtils.newHashMap(summaryMealVOS.size());
        Map<Long, SummaryMealVO> summaryMealVOMap = summaryMealVOS.stream()
                .collect(Collectors.toMap(SummaryMealVO::getMealId, Function.identity()));
        List<SummaryDetailVO> summaryDetailVOS = mealDetailService.selectSummaryDetail(
                summaryMealVOS.stream().map(SummaryMealVO::getMealId).collect(Collectors.toList()),
                userUid
        );
        for (SummaryDetailVO summaryDetailVO : summaryDetailVOS) {
            // need to add data into summary which mealId is #{mealId}
            Long mealId = summaryDetailVO.getMealId();

            // if there is no Summary information of this mealId, create a new one
            SummaryVO now = summaryResultMap.getOrDefault(mealId, new SummaryVO().setMealId(mealId));

            // if there is no meal information of this mealId, get it from summaryMealVOMap
            SummaryMealVO meal = Optional.ofNullable(now.getMeal()).orElse(summaryMealVOMap.get(mealId));
            if (ObjectUtils.isEmpty(meal)) continue; // if somehow meal is null, skip this loop. it shouldn't happen

            // get ingredients of this meal
            List<SummaryDetailVO> ingredients = Optional.ofNullable(now.getIngredients()).orElse(new ArrayList<>());
            ingredients.add(summaryDetailVO);

            // update data
            now.setMeal(calcDetailForMeal(meal, summaryDetailVO));
            summaryResultMap.put(mealId, now.setIngredients(ingredients));
        }
        return new ArrayList<>(summaryResultMap.values());
    }

    @Override
    public boolean clearAllMeal(String userUid) {
        if (lambdaUpdate().eq(Meal::getUserUid, userUid).remove()) {
            mealDetailService.lambdaUpdate().eq(MealDetail::getUserUid, userUid).remove();
        }
        return true;
    }

    @Override
    public boolean isConfirmMeal(Meal meal) {
        return !ObjectUtils.isEmpty(meal.getMealDate());
    }

    @Override
    public boolean isConfirmMeal(String mealId) {
        return isConfirmMeal(getById(mealId));
    }

    private boolean prepareRecommend(Meal meal) {
        // ingredients by preference (include type group information)
        List<IngredientType> acceptableType = ingredientTypeService.getAcceptableType(meal.getUserId());
        // recommend by type
        Map<Long, MealDetail> typeMap = new HashMap<>(acceptableType.size() * 2);
        for (IngredientType type : acceptableType) {
            MealDetail mealDetail = new MealDetail();
            mealDetail.setMealId(meal.getMealId()).setUserId(meal.getUserId()).setUserUid(meal.getUserUid());
            Integer proportion = SuggestStrategy.getProportionByFoodType(type.getTypeName());
//            proportion = proportion * SuggestStrategy.getProportionByBaseType(type.getBaseTypeName()) / 100;
            mealDetail.setIngredientId(type.getTypeId());
            mealDetail.setWeight((int) (meal.getTotalWeight() * proportion / 100.0))
                    .setCalories((int) (meal.getTotalCalories() * proportion / 100.0));
            typeMap.put(type.getTypeId(), mealDetail);
        }
        // recommend by base type
        return mealDetailService.saveBatch(ingredientService.recommendByBaseType(meal.getUserId(), typeMap));
    }

    private SummaryMealVO calcDetailForMeal(SummaryMealVO mealVO, SummaryDetailVO detailVO) {
//        mealVO.setTotalWeight(mealVO.getTotalWeight() + detailVO.getWeight());
//        mealVO.setTotalCalories(mealVO.getTotalCalories() + detailVO.getCalories());
        mealVO.setTotalProtein(mealVO.getTotalProtein() + detailVO.getProtein());
        mealVO.setTotalFat(mealVO.getTotalFat() + detailVO.getFat());
        mealVO.setTotalCarbohydrate(mealVO.getTotalCarbohydrate() + detailVO.getCarbohydrate());
        mealVO.setTotalSodium(mealVO.getTotalSodium() + detailVO.getSodium());
        return mealVO;
    }
}
