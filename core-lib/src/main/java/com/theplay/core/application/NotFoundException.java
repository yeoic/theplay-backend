package com.theplay.core.application;

public class NotFoundException extends BusinessException {

    public NotFoundException(String field, String message) {
        super(field, message);
    }
}
