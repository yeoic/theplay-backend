package com.theplay.core.domain;

import lombok.Getter;

@Getter
public class InvalidDomainDataException extends RuntimeException {

    private final String field;

    public InvalidDomainDataException(String field, String message) {
        super(message);
        this.field = field;
    }
}
