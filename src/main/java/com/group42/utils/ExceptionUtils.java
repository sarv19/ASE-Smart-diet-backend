package com.group42.utils;


import com.group42.excpetion.ServiceException;

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

    public static String errorMsg = StringUtils.EMPTY;

    public static ServiceException newSE() {
        return new ServiceException();
    }

    public static ServiceException newSER() {
        ServiceException serviceException = new ServiceException(ExceptionUtils.errorMsg);
        errorMsg = StringUtils.EMPTY;
        return serviceException;
    }

    public static ServiceException newSER(String errorMsg) {
        return new ServiceException(errorMsg);
    }

    public static <T> T getOrThrow(T obj){
        return Optional.ofNullable(obj).orElseThrow(ExceptionUtils::newSER);
    }
    public static <T> T getOrThrow(T obj, String msg){
        return Optional.ofNullable(obj).orElseThrow(() -> new ServiceException(msg));
    }

}
