package com.theplay.core.presentation;

import static java.util.stream.Collectors.toList;

import com.theplay.core.application.BusinessException;
import com.theplay.core.application.NotFoundException;
import com.theplay.core.domain.InvalidDomainDataException;
import com.theplay.core.presentation.response.Error;
import com.theplay.core.presentation.response.Response;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ServerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<Response<Void>> handle(MethodArgumentNotValidException e) {
        log.warn("invalid request", e);
        List<Error> errors = e.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> new Error(fieldError.getField(), fieldError.getDefaultMessage()))
                .collect(toList());
        return Response.badRequest(errors);
    }

    @ExceptionHandler(InvalidDomainDataException.class)
    ResponseEntity<Response<Void>> handle(InvalidDomainDataException e) {
        log.warn("invalid domain data", e);
        return Response.badRequest(List.of(new Error(e.getField(), e.getMessage())));
    }

    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<Response<Void>> handle(NotFoundException e) {
        log.warn("resource not found", e);
        return Response.notFound(List.of(new Error(e.getField(), e.getMessage())));
    }

    @ExceptionHandler(BusinessException.class)
    ResponseEntity<Response<Void>> handle(BusinessException e) {
        log.warn("business rule violated", e);
        return Response.badRequest(List.of(new Error(e.getField(), e.getMessage())));
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<Response<Void>> handle(Exception e) {
        log.error("unhandled exception", e);
        return Response.serverError(List.of(Error.of("서버 오류가 발생했습니다.")));
    }
}
