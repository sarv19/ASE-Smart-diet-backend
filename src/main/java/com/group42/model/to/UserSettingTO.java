package com.group42.model.to;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * UserSettingTO
 *
 * @author Guofeng Lin
 * @since 2023/2/27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserSettingTO extends BaseTO{
    private Integer targetCaloriesMin;

    private Integer targetCaloriesMax;

    private Integer targetProteinMin;

    private Integer targetProteinMax;

    private Integer targetCarbohydrateMax;

    private Integer targetCarbohydrateMin;

    private Integer targetFatMin;

    private Integer targetFatMax;

    private Integer targetMineralsMin;

    private Integer targetMineralsMax;
}
