package com.group42.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * JwtUtils
 *
 * @author Guofeng Lin
 * @since 2023/2/24
 */
public class JwtUtils {
    public static String getUserUidFromRequest(HttpServletRequest request) {
        String userUid = Optional.ofNullable(request.getHeader("authorization")).orElse(StringUtils.EMPTY);
        return userUid.replace("Bearer ", "").trim();
    }
}
