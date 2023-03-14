package com.group42.constant;

import com.group42.utils.DateUtils;

/**
 * Constants
 *
 * @author Guofeng Lin
 * @since 2023/2/9
 */
public class Constants {
    /**
     * Time prefix format for id generation
     */
    public static final String idTimePrefixFormat = DateUtils.YYYYMMDDHHMMSS;
    /**
     * Address collection that does not need to be verified
     */
    public static final String[] BYPASS_PATHS = {
            "/login",
            "/logout",
            "/register"
    };

    public static String[] getBypassPaths() {
        String[] SecurityBypassPaths = new String[Constants.BYPASS_PATHS.length];
        for (int i = 0; i < BYPASS_PATHS.length; i++) {
            SecurityBypassPaths[i] = "/**/" + BYPASS_PATHS[i];
        }
        return SecurityBypassPaths;
    }
}
