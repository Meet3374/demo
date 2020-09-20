package com.lucent.demo.exception;

public class BusinessValidationException extends RuntimeException {

    private String msg;

    public BusinessValidationException(String msg) {
        super(msg);
    }

    public String getMsg() {
        return msg;
    }

}
