package com.theplay.core.infrastructure;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.theplay.core.domain.AbstractDomainEvent;
import com.theplay.core.domain.AggregateRoot;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
public abstract class DomainEventPublishRepositorySupport<T extends AggregateRoot<ID>, ID> {

    private final ApplicationEventPublisher eventPublisher;
    protected final JPAQueryFactory queryFactory;

    @PersistenceContext
    private EntityManager entityManager;

    protected DomainEventPublishRepositorySupport(ApplicationEventPublisher eventPublisher,
                                                  JPAQueryFactory queryFactory) {
        this.eventPublisher = eventPublisher;
        this.queryFactory = queryFactory;
    }

    @Transactional
    public T save(T aggregate) {
        T saved = persistOrMerge(aggregate);
        publishEvents(aggregate);
        return saved;
    }

    @Transactional
    public List<T> saveAll(List<T> aggregates) {
        List<T> saved = aggregates.stream().map(this::persistOrMerge).toList();
        aggregates.forEach(this::publishEvents);
        return saved;
    }

    @Transactional
    public void delete(T aggregate) {
        aggregate.markDeleted(LocalDateTime.now());
        if (!entityManager.contains(aggregate)) {
            entityManager.merge(aggregate);
        }
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    private T persistOrMerge(T aggregate) {
        if (entityManager.contains(aggregate)) {
            return aggregate;
        }
        if (aggregate.getId() == null) {
            entityManager.persist(aggregate);
            return aggregate;
        }
        return entityManager.merge(aggregate);
    }

    private void publishEvents(T aggregate) {
        for (AbstractDomainEvent<ID> event : aggregate.popAllEvents()) {
            eventPublisher.publishEvent(event);
            log.info("publish domain event : {}", event);
        }
    }
}
