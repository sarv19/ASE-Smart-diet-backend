package com.group42.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author Guofeng Lin
 * @since 2023-02-10
 */

@TableName(value = "user")
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User extends BaseEntity {

    /**
     * user Id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long userId;

    private String userUid;

    private String userName;

    @JsonIgnore
    private String password;

    private String fullName;

    /**
     * male, female, universal, unknown
     */
    private String gender;

    private String emailAddress;

    private String phoneNumber;

    private String address;

}
