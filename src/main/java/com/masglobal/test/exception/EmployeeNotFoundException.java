package com.masglobal.test.exception;

public class EmployeeNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 20210214L;

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
