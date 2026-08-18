package com.theplay.core.domain;

public interface DomainEvent<T> {

    T getDomainId();
}
