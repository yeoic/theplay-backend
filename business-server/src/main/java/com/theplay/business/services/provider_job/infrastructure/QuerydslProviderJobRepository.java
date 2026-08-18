package com.theplay.business.services.provider_job.infrastructure;

import static com.theplay.business.services.provider_job.domain.QProviderJob.providerJob;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.theplay.business.services.provider_job.domain.ProviderJob;
import com.theplay.business.services.provider_job.domain.ProviderJobRepository;
import com.theplay.business.services.provider_job.domain.ProviderJobSearchCondition;
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
class QuerydslProviderJobRepository extends DomainEventPublishRepositorySupport<ProviderJob, Long>
        implements ProviderJobRepository {

    QuerydslProviderJobRepository(ApplicationEventPublisher eventPublisher, JPAQueryFactory queryFactory) {
        super(eventPublisher, queryFactory);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProviderJob> findById(long id) {
        return Optional.ofNullable(queryFactory
                .selectFrom(providerJob)
                .where(providerJob.id.eq(id), providerJob.deletedAt.isNull())
                .fetchFirst());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProviderJob> findAll(ProviderJobSearchCondition condition, Pageable pageable) {
        List<ProviderJob> contents = queryFactory
                .selectFrom(providerJob)
                .where(
                        providerJob.deletedAt.isNull(),
                        containsName(condition.name()),
                        eqProviderId(condition.providerId()))
                .orderBy(providerJob.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory
                .select(providerJob.count())
                .from(providerJob)
                .where(
                        providerJob.deletedAt.isNull(),
                        containsName(condition.name()),
                        eqProviderId(condition.providerId()));

        return PageableExecutionUtils.getPage(contents, pageable, countQuery::fetchOne);
    }

    private BooleanExpression containsName(String name) {
        return StringUtils.hasText(name) ? providerJob.name.contains(name) : null;
    }

    private BooleanExpression eqProviderId(Long providerId) {
        return providerId == null ? null : providerJob.providerId.eq(providerId);
    }
}
