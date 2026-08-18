package com.theplay.core.presentation.response;

import java.util.List;
import java.util.function.Function;
import org.springframework.data.domain.Page;

public record PageResource<T>(List<T> contents, int page, int size, long totalElements, int totalPages) {

    public static <E, T> PageResource<T> of(Page<E> page, Function<E, T> mapper) {
        return new PageResource<>(
                page.getContent().stream().map(mapper).toList(),
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages());
    }
}
