package com.group42.constant;

public enum ErrorEnum {

    ACCOUNT_BANNED(202, "account banned"),
    TOKEN_INVALID(300, "token invalid"),
    USER_NOT_EXISTS(301, "user not exists"),
    BAD_PARAM(400, "bad param"),

    ERROR_ACCOUNT(401, "wrong username or password"),
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
