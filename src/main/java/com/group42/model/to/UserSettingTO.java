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
    private String gender;
    private String address;

}
