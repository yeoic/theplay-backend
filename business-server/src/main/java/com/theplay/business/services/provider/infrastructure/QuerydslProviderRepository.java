package com.theplay.business.services.provider.infrastructure;

import static com.theplay.business.services.provider.domain.QProvider.provider;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.theplay.business.services.provider.domain.Provider;
import com.theplay.business.services.provider.domain.ProviderCategory;
import com.theplay.business.services.provider.domain.ProviderRepository;
import com.theplay.business.services.provider.domain.ProviderSearchCondition;
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
class QuerydslProviderRepository extends DomainEventPublishRepositorySupport<Provider, Long>
        implements ProviderRepository {

    QuerydslProviderRepository(ApplicationEventPublisher eventPublisher, JPAQueryFactory queryFactory) {
        super(eventPublisher, queryFactory);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Provider> findById(long id) {
        return Optional.ofNullable(queryFactory
                .selectFrom(provider)
                .where(provider.id.eq(id), provider.deletedAt.isNull())
                .fetchFirst());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Provider> findAll(ProviderSearchCondition condition, Pageable pageable) {
        List<Provider> contents = queryFactory
                .selectFrom(provider)
                .where(
                        provider.deletedAt.isNull(),
                        containsName(condition.name()),
                        eqCategory(condition.category()))
                .orderBy(provider.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory
                .select(provider.count())
                .from(provider)
                .where(
                        provider.deletedAt.isNull(),
                        containsName(condition.name()),
                        eqCategory(condition.category()));

        return PageableExecutionUtils.getPage(contents, pageable, countQuery::fetchOne);
    }

    private BooleanExpression containsName(String name) {
        return StringUtils.hasText(name) ? provider.name.contains(name) : null;
    }

    private BooleanExpression eqCategory(ProviderCategory category) {
        return category == null ? null : provider.category.eq(category);
    }
}
