//package com.group42.excpetion;
//
//import java.io.Serial;
//
///**
// * 业务异常
// *
// * @author zhouzhifeng
// */
//public final class ServiceException extends RuntimeException {
//    @Serial
//    private static final long serialVersionUID = 1L;
//
//    /**
//     * 错误码
//     */
//    private Integer code;
//
//    /**
//     * 错误提示
//     */
//    private String message;
//
//    /**
//     * 错误明细，内部调试错误
//     */
//    private String detailMessage;
//
//    /**
//     * 空构造方法，避免反序列化问题
//     */
//    public ServiceException() {
//    }
//
//    public ServiceException(String message) {
//        this.message = message;
//    }
//
//    public ServiceException(String message, Integer code) {
//        this.message = message;
//        this.code = code;
//    }
//
//    public ServiceException(ErrorEnum errorEnum) {
//        super(errorEnum.getMessage());
//        this.message = errorEnum.getMessage();
//        this.code = errorEnum.getCode();
//    }
//
//    public String getDetailMessage() {
//        return detailMessage;
//    }
//
//    public ServiceException setDetailMessage(String detailMessage) {
//        this.detailMessage = detailMessage;
//        return this;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public ServiceException setMessage(String message) {
//        this.message = message;
//        return this;
//    }
//
//    public Integer getCode() {
//        return code;
//    }
//}