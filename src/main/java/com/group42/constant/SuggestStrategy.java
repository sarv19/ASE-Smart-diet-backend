package com.group42.constant;

/**
 * SuggestStrategy
 *
 * @author Guofeng Lin
 * @since 2023/2/11
 */
public class SuggestStrategy {
    // calories proportion
    public static final String BREAKFAST = "breakfast";
    public static final String LUNCH = "lunch";
    public static final String DINNER = "dinner";
    public static final Integer BREAKFAST_PROPORTION = 30;
    public static final Integer LUNCH_PROPORTION = 40;
    public static final Integer DINNER_PROPORTION = 30;
    public static final Integer OTHER_PROPORTION = 10;

    // food type proportion
    public static final String PROTEIN_BASE_TYPE = "protein";
    public static final String VEGETABLE_BASE_TYPE = "vegetable";
    public static final String SUGARS_BASE_TYPE = "sugars";
    public static final Integer PROTEIN_BASE_PROPORTION = 20;
    public static final Integer VEGETABLE_BASE_PROPORTION = 30;
    public static final Integer SUGARS_BASE_PROPORTION = 50;
    public static final String GRAINS_TYPE = "grains";
    public static final String BEANS_TYPE = "beans";
    public static final String MEAT_TYPE = "meat";
    public static final String MILK_TYPE = "milk";
    public static final String VEGETABLE_TYPE = "vegetable";
    public static final String FRUIT_TYPE = "fruit";

    public static final Integer GRAINS_PROPORTION = 45;
    public static final Integer BEANS_PROPORTION = 10;
    public static final Integer MEAT_PROPORTION = 25;
    public static final Integer MILK_PROPORTION = 15;
    public static final Integer VEGETABLE_PROPORTION = 30;
    public static final Integer FRUIT_PROPORTION = 10;

    public static Integer getProportionByMealType(String mealType) {
        return switch (mealType) {
            case BREAKFAST -> BREAKFAST_PROPORTION;
            case LUNCH -> LUNCH_PROPORTION;
            case DINNER -> DINNER_PROPORTION;
            default -> OTHER_PROPORTION;
        };
    }

    public static Integer getProportionByBaseType(String baseTypeName) {
        return switch (baseTypeName) {
            case PROTEIN_BASE_TYPE -> PROTEIN_BASE_PROPORTION;
            case VEGETABLE_BASE_TYPE -> VEGETABLE_BASE_PROPORTION;
            case SUGARS_BASE_TYPE -> SUGARS_BASE_PROPORTION;
            default -> 10;
        };
    }

    public static Integer getProportionByFoodType(String typeName) {
        return switch (typeName) {
            case GRAINS_TYPE -> GRAINS_PROPORTION;
            case BEANS_TYPE -> BEANS_PROPORTION;
            case MEAT_TYPE -> MEAT_PROPORTION;
            case MILK_TYPE -> MILK_PROPORTION;
            case VEGETABLE_TYPE -> VEGETABLE_PROPORTION;
            case FRUIT_TYPE -> FRUIT_PROPORTION;
            default -> 10;
        };
    }

}
