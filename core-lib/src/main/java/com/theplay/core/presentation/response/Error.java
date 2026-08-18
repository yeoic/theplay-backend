package com.theplay.core.presentation.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Error(String field, String message) {

    public static Error of(String message) {
        return new Error(null, message);
    }
}
