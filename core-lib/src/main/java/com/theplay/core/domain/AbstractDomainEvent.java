package com.theplay.core.domain;

import lombok.ToString;

@ToString
public abstract class AbstractDomainEvent<T> implements DomainEvent<T> {

    private T domainId;

    protected AbstractDomainEvent(T domainId) {
        this.domainId = domainId;
    }

    @Override
    public T getDomainId() {
        return domainId;
    }

    void assignDomainIdIfAbsent(T domainId) {
        if (this.domainId == null) {
            this.domainId = domainId;
        }
    }
}
