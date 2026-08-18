package com.theplay.business.services.venue.infrastructure;

import static com.theplay.business.services.venue.domain.QVenue.venue;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.theplay.business.services.venue.domain.Venue;
import com.theplay.business.services.venue.domain.VenueRepository;
import com.theplay.business.services.venue.domain.VenueSearchCondition;
import com.theplay.core.infrastructure.DomainEventPublishRepositorySupport;
import java.util.List;
import java.util.Optional;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Repository
class QuerydslVenueRepository extends DomainEventPublishRepositorySupport<Venue, Long>
        implements VenueRepository {

    QuerydslVenueRepository(ApplicationEventPublisher eventPublisher, JPAQueryFactory queryFactory) {
        super(eventPublisher, queryFactory);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Venue> findById(long id) {
        return Optional.ofNullable(queryFactory
                .selectFrom(venue)
                .where(venue.id.eq(id), venue.deletedAt.isNull())
                .fetchFirst());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Venue> findAll(VenueSearchCondition condition, Pageable pageable) {
        List<Venue> contents = queryFactory
                .selectFrom(venue)
                .where(
                        venue.deletedAt.isNull(),
                        containsName(condition.name()),
                        eqOutdoor(condition.outdoor()))
                .orderBy(venue.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory
                .select(venue.count())
                .from(venue)
                .where(
                        venue.deletedAt.isNull(),
                        containsName(condition.name()),
                        eqOutdoor(condition.outdoor()));

        return PageableExecutionUtils.getPage(contents, pageable, countQuery::fetchOne);
    }

    private BooleanExpression containsName(String name) {
        return StringUtils.hasText(name) ? venue.name.contains(name) : null;
    }

    private BooleanExpression eqOutdoor(Boolean outdoor) {
        return outdoor == null ? null : venue.outdoor.eq(outdoor);
    }
}
