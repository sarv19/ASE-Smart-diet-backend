package com.group42.constant;

/**
 * Constants
 *
 * @author Guofeng Lin
 * @since 2023/2/9
 */
public class Constants {
    /**
     * 不需要验证Token的地址集合
     */
    public static final String[] BYPASS_PATHS = {
            "/login",
            "/logout"
    };
}
