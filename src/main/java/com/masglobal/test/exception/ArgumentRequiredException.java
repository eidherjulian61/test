package com.masglobal.test.exception;

public class ArgumentRequiredException extends RuntimeException {

    private static final long serialVersionUID = 20210214L;

    public ArgumentRequiredException(String message) {
        super(message);
    }

}