package com.example.testing.exception;

public enum ExceptionCode {
    NOT_EXISTING_EMPLOYEE("4000"),
    NOT_EXISTING_DEPARTMENT("4001"),
    NOT_EXISTING_GENDER("4002");

    private final String errorCode;

    ExceptionCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
