package com.theplay.business.services.workspace.infrastructure;

import static com.theplay.business.services.workspace.domain.QWorkspace.workspace;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.theplay.business.services.workspace.domain.Workspace;
import com.theplay.business.services.workspace.domain.WorkspaceRepository;
import com.theplay.business.services.workspace.domain.WorkspaceSearchCondition;
import com.theplay.business.services.workspace.domain.WorkspaceType;
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
class QuerydslWorkspaceRepository extends DomainEventPublishRepositorySupport<Workspace, Long>
        implements WorkspaceRepository {

    QuerydslWorkspaceRepository(ApplicationEventPublisher eventPublisher, JPAQueryFactory queryFactory) {
        super(eventPublisher, queryFactory);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Workspace> findById(long id) {
        return Optional.ofNullable(queryFactory
                .selectFrom(workspace)
                .where(workspace.id.eq(id), workspace.deletedAt.isNull())
                .fetchFirst());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Workspace> findAll(WorkspaceSearchCondition condition, Pageable pageable) {
        List<Workspace> contents = queryFactory
                .selectFrom(workspace)
                .where(
                        workspace.deletedAt.isNull(),
                        containsName(condition.name()),
                        eqType(condition.type()))
                .orderBy(workspace.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory
                .select(workspace.count())
                .from(workspace)
                .where(
                        workspace.deletedAt.isNull(),
                        containsName(condition.name()),
                        eqType(condition.type()));

        return PageableExecutionUtils.getPage(contents, pageable, countQuery::fetchOne);
    }

    private BooleanExpression containsName(String name) {
        return StringUtils.hasText(name) ? workspace.name.contains(name) : null;
    }

    private BooleanExpression eqType(WorkspaceType type) {
        return type == null ? null : workspace.type.eq(type);
    }
}
