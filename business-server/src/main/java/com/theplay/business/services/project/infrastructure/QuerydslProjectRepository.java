package com.theplay.business.services.project.infrastructure;

import static com.theplay.business.services.project.domain.QProject.project;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.theplay.business.services.project.domain.Project;
import com.theplay.business.services.project.domain.ProjectRepository;
import com.theplay.business.services.project.domain.ProjectSearchCondition;
import com.theplay.business.services.project.domain.ProjectStatus;
import com.theplay.core.infrastructure.DomainEventPublishRepositorySupport;
import java.time.LocalDate;
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
class QuerydslProjectRepository extends DomainEventPublishRepositorySupport<Project, Long>
        implements ProjectRepository {

    QuerydslProjectRepository(ApplicationEventPublisher eventPublisher, JPAQueryFactory queryFactory) {
        super(eventPublisher, queryFactory);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Project> findById(long id) {
        return Optional.ofNullable(queryFactory
                .selectFrom(project)
                .where(project.id.eq(id), project.deletedAt.isNull())
                .fetchFirst());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Project> findAll(ProjectSearchCondition condition, Pageable pageable) {
        List<Project> contents = queryFactory
                .selectFrom(project)
                .where(
                        project.deletedAt.isNull(),
                        containsName(condition.name()),
                        eqCustomerId(condition.customerId()),
                        eqStatus(condition.status()),
                        goePerformanceDate(condition.performanceDateFrom()),
                        loePerformanceDate(condition.performanceDateTo()))
                .orderBy(project.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory
                .select(project.count())
                .from(project)
                .where(
                        project.deletedAt.isNull(),
                        containsName(condition.name()),
                        eqCustomerId(condition.customerId()),
                        eqStatus(condition.status()),
                        goePerformanceDate(condition.performanceDateFrom()),
                        loePerformanceDate(condition.performanceDateTo()));

        return PageableExecutionUtils.getPage(contents, pageable, countQuery::fetchOne);
    }

    private BooleanExpression containsName(String name) {
        return StringUtils.hasText(name) ? project.name.contains(name) : null;
    }

    private BooleanExpression eqCustomerId(Long customerId) {
        return customerId == null ? null : project.customerId.eq(customerId);
    }

    private BooleanExpression eqStatus(ProjectStatus status) {
        return status == null ? null : project.status.eq(status);
    }

    private BooleanExpression goePerformanceDate(LocalDate from) {
        return from == null ? null : project.performanceDate.goe(from);
    }

    private BooleanExpression loePerformanceDate(LocalDate to) {
        return to == null ? null : project.performanceDate.loe(to);
    }
}
