package com.group42.model.to;

import com.group42.model.valid.Insert;
import com.group42.model.valid.Query;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * UserTO
 *
 * @author Guofeng Lin
 * @since 2023/2/24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserTO extends BaseTO{
    @NotNull(groups = Insert.class)
    private String userUid;

    @NotNull(groups = Insert.class)
    private String email;

    @NotBlank(groups = Query.class)
    private String username;
    @NotBlank(groups = Query.class)
    private String password;
}
