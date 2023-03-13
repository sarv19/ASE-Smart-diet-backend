package com.group42.model.vo;

import lombok.Data;

/**
 * UserVO
 *
 * @author Guofeng Lin
 * @since 2023/3/13
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserVO {
    private String fullName;

    /**
     * male, female, universal, unknown
     */
    private String gender;

    private String emailAddress;

    private String phoneNumber;

    private String address;
}
