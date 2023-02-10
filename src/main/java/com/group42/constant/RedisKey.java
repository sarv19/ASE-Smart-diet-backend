package com.group42.constant;

/**
 * Redis key constants
 */
public class RedisKey {

    private static final String LOGIN_TOKEN = "login_token:";
    private static final String TOKEN_USER_INFO_KEY = "token_user_info:";

    public static String getTokenUserInfo(String token) {
        return TOKEN_USER_INFO_KEY + token;
    }

    public static String getLoginToken(String username) {
        return LOGIN_TOKEN + username;
    }

}
