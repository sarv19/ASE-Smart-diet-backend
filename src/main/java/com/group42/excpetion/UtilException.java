package com.group42.excpetion;

import java.io.Serial;

public class UtilException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 8247610319171014183L;

    public UtilException(Throwable e) {
        super(e.getMessage());
    }

    public UtilException(String message) {
        super(message);
    }

    public UtilException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
