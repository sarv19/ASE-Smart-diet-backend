package com.group42.model.bean;


import com.alibaba.fastjson2.JSONObject;
import com.group42.constant.ErrorEnum;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.util.HashMap;

public class R extends HashMap<String, Object> {

    public static final String CODE_TAG = "code";
    public static final String MSG_TAG = "msg";
    public static final String DATA_TAG = "data";

    public static final String SUCCESS = "success";
    public static final String ERROR = "error";
    @Serial
    private static final long serialVersionUID = 1L;

    public R() {
    }

    public R(ErrorEnum errorEnum) {
        this(errorEnum.getCode(), errorEnum.getMessage(), null);
    }

    public R(int code, String msg, Object data) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if (null != data) {
            super.put(DATA_TAG, data);
        }
    }

    public static R ok() {
        return R.ok(SUCCESS);
    }

    public static R ok(Object data) {
        return R.ok(SUCCESS, data);
    }

    public static R ok(String msg) {
        return R.ok(msg, null);
    }

    public static R ok(String msg, Object data) {
        return new R(HttpStatus.OK.value(), msg, data);
    }

    public static R error() {
        return R.error(ERROR);
    }

    public static R error(String msg) {
        return R.error(msg, null);
    }


    public static R error(String msg, Object data) {
        return new R(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg, data);
    }

    public static R error(int code, String msg) {
        return new R(code, msg, null);
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
