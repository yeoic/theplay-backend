package com.theplay.business.services.asset.infrastructure;

import static com.theplay.business.services.asset.domain.QAsset.asset;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.theplay.business.services.asset.domain.Asset;
import com.theplay.business.services.asset.domain.AssetCategory;
import com.theplay.business.services.asset.domain.AssetRepository;
import com.theplay.business.services.asset.domain.AssetSearchCondition;
import com.theplay.business.services.asset.domain.AssetStatus;
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
class QuerydslAssetRepository extends DomainEventPublishRepositorySupport<Asset, Long>
        implements AssetRepository {

    QuerydslAssetRepository(ApplicationEventPublisher eventPublisher, JPAQueryFactory queryFactory) {
        super(eventPublisher, queryFactory);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Asset> findById(long id) {
        return Optional.ofNullable(queryFactory
                .selectFrom(asset)
                .where(asset.id.eq(id), asset.deletedAt.isNull())
                .fetchFirst());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Asset> findAll(AssetSearchCondition condition, Pageable pageable) {
        List<Asset> contents = queryFactory
                .selectFrom(asset)
                .where(
                        asset.deletedAt.isNull(),
                        containsName(condition.name()),
                        eqCategory(condition.category()),
                        eqStatus(condition.status()),
                        eqWorkspaceId(condition.workspaceId()))
                .orderBy(asset.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory
                .select(asset.count())
                .from(asset)
                .where(
                        asset.deletedAt.isNull(),
                        containsName(condition.name()),
                        eqCategory(condition.category()),
                        eqStatus(condition.status()),
                        eqWorkspaceId(condition.workspaceId()));

        return PageableExecutionUtils.getPage(contents, pageable, countQuery::fetchOne);
    }

    private BooleanExpression containsName(String name) {
        return StringUtils.hasText(name) ? asset.name.contains(name) : null;
    }

    private BooleanExpression eqCategory(AssetCategory category) {
        return category == null ? null : asset.category.eq(category);
    }

    private BooleanExpression eqStatus(AssetStatus status) {
        return status == null ? null : asset.status.eq(status);
    }

    private BooleanExpression eqWorkspaceId(Long workspaceId) {
        return workspaceId == null ? null : asset.workspaceId.eq(workspaceId);
    }
}
