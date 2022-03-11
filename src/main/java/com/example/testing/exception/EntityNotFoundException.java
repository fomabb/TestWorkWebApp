package com.example.testing.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String errorCode) {
        super(errorCode);
    }
}
