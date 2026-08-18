package com.theplay.core.presentation.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Response<T>(T data, boolean success, List<Error> errors) {

    public static <T> ResponseEntity<Response<T>> ok(T data) {
        return ResponseEntity.ok(success(data));
    }

    public static <T> ResponseEntity<Response<T>> created(T data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(success(data));
    }

    public static <T> ResponseEntity<Response<T>> badRequest(List<Error> errors) {
        return ResponseEntity.badRequest().body(failure(errors));
    }

    public static <T> ResponseEntity<Response<T>> notFound(List<Error> errors) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(failure(errors));
    }

    public static <T> ResponseEntity<Response<T>> serverError(List<Error> errors) {
        return ResponseEntity.internalServerError().body(failure(errors));
    }

    private static <T> Response<T> success(T data) {
        return new Response<>(data, true, null);
    }

    private static <T> Response<T> failure(List<Error> errors) {
        return new Response<>(null, false, errors);
    }
}
