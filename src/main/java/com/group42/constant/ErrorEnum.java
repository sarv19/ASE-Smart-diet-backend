package com.group42.constant;

public enum ErrorEnum {

    ACCOUNT_BANNED(202, "account banned"),
    TOKEN_INVALID(300, "token invalid"),
    BAD_PARAM(400, "bad param"),

    NEED_AUTHORIZATION(401, "authorization header is not exists"),
    NO_AUTHORIZED(402, "No authorized"),
    NOT_FOUND(404, "Not found"),
    SERVER_ERROR(500, "service error");


    private final int code;
    private final String message;

    ErrorEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
