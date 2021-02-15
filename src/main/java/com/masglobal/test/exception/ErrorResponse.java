package com.masglobal.test.exception;

public class ErrorResponse extends RuntimeException {

    private static final long serialVersionUID = 20210214L;

    public ErrorResponse(String message) {
        super(message);
    }

}
