package com.theplay.core.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AggregateRoot<ID> {

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Transient
    private final List<AbstractDomainEvent<ID>> events = new ArrayList<>();

    public abstract ID getId();

    protected void register(AbstractDomainEvent<ID> event) {
        this.events.add(event);
    }

    public List<AbstractDomainEvent<ID>> popAllEvents() {
        if (events.isEmpty()) {
            return List.of();
        }
        events.forEach(event -> event.assignDomainIdIfAbsent(getId()));

        List<AbstractDomainEvent<ID>> popped = List.copyOf(events);
        events.clear();
        return popped;
    }

    public void markDeleted(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public boolean isDeleted() {
        return deletedAt != null;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }
}
