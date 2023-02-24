package com.group42.utils;


import com.group42.excpetion.ServiceException;
import com.group42.excpetion.UtilException;

import java.util.Optional;

/**
 * ExceptionUtils
 * 用于抛出异常
 *
 * @author vskendo
 * @since 2022/9/27
 */
public class ExceptionUtils {
    private ExceptionUtils() {
    }


    public static ServiceException newSE() {
        return new ServiceException();
    }

    public static ServiceException newSE(String errorMsg) {
        return new ServiceException(errorMsg);
    }

    public static UtilException newUE(String errorMsg) {
        return new UtilException(errorMsg);
    }

    public static <T> T getOrThrow(T obj) {
        return Optional.ofNullable(obj).orElseThrow(() -> new ServiceException("Object is null"));
    }

    public static <T> T getOrThrow(T obj, String msg) {
        return Optional.ofNullable(obj).orElseThrow(() -> new ServiceException(msg));
    }

}
