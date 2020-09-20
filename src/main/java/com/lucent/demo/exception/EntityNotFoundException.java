package com.lucent.demo.exception;

public class EntityNotFoundException extends RuntimeException {

    private String msg;

    public EntityNotFoundException() {
        super();
    }

    public EntityNotFoundException(String msg) {
        super(msg);
    }

    public String getMsg() {
        return msg;
    }

}
