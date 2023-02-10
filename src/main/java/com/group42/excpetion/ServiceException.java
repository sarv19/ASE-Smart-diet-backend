package com.group42.excpetion;

import com.group42.constant.ErrorEnum;

import java.io.Serial;

public final class ServiceException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    private Integer code;
    private String message;
    private String detailMessage;

    public ServiceException() {
    }

    public ServiceException(String message) {
        this.message = message;
    }

    public ServiceException(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public ServiceException(ErrorEnum errorEnum) {
        super(errorEnum.getMessage());
        this.message = errorEnum.getMessage();
        this.code = errorEnum.getCode();
    }

    public String getDetailMessage() {
        return detailMessage;
    }

    public ServiceException setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ServiceException setMessage(String message) {
        this.message = message;
        return this;
    }

    public Integer getCode() {
        return code;
    }
}