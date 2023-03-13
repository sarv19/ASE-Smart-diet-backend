package com.group42.model.to;

import com.group42.model.valid.Delete;
import com.group42.model.valid.Insert;
import com.group42.model.valid.Update;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * @author Guofeng Lin
 * @since 2023/3/6
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class EatingPerformanceTO extends BaseTO {
    @NotNull(groups = {Update.class, Delete.class})
    @Null(groups = {Insert.class})
    private Long targetId;

    @NotNull(groups = {Update.class, Insert.class})
    private Integer targetCaloriesMin;

    @NotNull(groups = {Update.class, Insert.class})
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
