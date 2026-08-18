package com.theplay.business.services.project.infrastructure;

import static com.theplay.business.services.project.domain.QProjectItem.projectItem;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.theplay.business.services.project.domain.ProjectItem;
import com.theplay.business.services.project.domain.ProjectItemRepository;
import com.theplay.business.services.project.domain.ProjectItemSearchCondition;
import com.theplay.business.services.project.domain.ProjectItemStatus;
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
class QuerydslProjectItemRepository extends DomainEventPublishRepositorySupport<ProjectItem, Long>
        implements ProjectItemRepository {

    QuerydslProjectItemRepository(ApplicationEventPublisher eventPublisher, JPAQueryFactory queryFactory) {
        super(eventPublisher, queryFactory);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProjectItem> findById(long id) {
        return Optional.ofNullable(queryFactory
                .selectFrom(projectItem)
                .where(projectItem.id.eq(id), projectItem.deletedAt.isNull())
                .fetchFirst());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProjectItem> findAll(ProjectItemSearchCondition condition, Pageable pageable) {
        List<ProjectItem> contents = queryFactory
                .selectFrom(projectItem)
                .where(
                        projectItem.deletedAt.isNull(),
                        eqProjectId(condition.projectId()),
                        eqProviderJobId(condition.providerJobId()),
                        eqStatus(condition.status()))
                .orderBy(projectItem.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory
                .select(projectItem.count())
                .from(projectItem)
                .where(
                        projectItem.deletedAt.isNull(),
                        eqProjectId(condition.projectId()),
                        eqProviderJobId(condition.providerJobId()),
                        eqStatus(condition.status()));

        return PageableExecutionUtils.getPage(contents, pageable, countQuery::fetchOne);
    }

    private BooleanExpression eqProjectId(Long projectId) {
        return projectId == null ? null : projectItem.projectId.eq(projectId);
    }

    private BooleanExpression eqProviderJobId(Long providerJobId) {
        return providerJobId == null ? null : projectItem.providerJobId.eq(providerJobId);
    }

    private BooleanExpression eqStatus(ProjectItemStatus status) {
        return status == null ? null : projectItem.status.eq(status);
    }
}
