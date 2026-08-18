package com.theplay.core.application;

public interface Specification<T> {

    void verifySatisfy(T target);
}
