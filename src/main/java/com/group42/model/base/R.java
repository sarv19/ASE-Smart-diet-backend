package com.group42.model.base;


import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.util.HashMap;

public class R extends HashMap<String, Object> {

    public static final String CODE_TAG = "code";
    public static final String MSG_TAG = "msg";
    public static final String DATA_TAG = "data";
    @Serial
    private static final long serialVersionUID = 1L;

    public R() {
    }

    public R(int code, String msg, Object data) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if (null != data) {
            super.put(DATA_TAG, data);
        }
    }

    public static R ok() {
        return R.ok("操作成功");
    }

    public static R ok(Object data) {
        return R.ok("操作成功", data);
    }

    public static R ok(String msg) {
        return R.ok(msg, null);
    }

    public static R ok(String msg, Object data) {
        return new R(HttpStatus.OK.value(), msg, data);
    }

    public static R error() {
        return R.error("操作失败");
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
}
