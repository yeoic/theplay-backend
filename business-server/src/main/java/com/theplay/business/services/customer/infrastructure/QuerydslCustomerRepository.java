package com.theplay.business.services.customer.infrastructure;

import static com.theplay.business.services.customer.domain.QCustomer.customer;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.theplay.business.services.customer.domain.Customer;
import com.theplay.business.services.customer.domain.CustomerRepository;
import com.theplay.business.services.customer.domain.CustomerSearchCondition;
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
class QuerydslCustomerRepository extends DomainEventPublishRepositorySupport<Customer, Long>
        implements CustomerRepository {

    QuerydslCustomerRepository(ApplicationEventPublisher eventPublisher, JPAQueryFactory queryFactory) {
        super(eventPublisher, queryFactory);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Customer> findById(long id) {
        return Optional.ofNullable(queryFactory
                .selectFrom(customer)
                .where(customer.id.eq(id), customer.deletedAt.isNull())
                .fetchFirst());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Customer> findAll(CustomerSearchCondition condition, Pageable pageable) {
        List<Customer> contents = queryFactory
                .selectFrom(customer)
                .where(
                        customer.deletedAt.isNull(),
                        containsName(condition.name()),
                        containsPhoneNumber(condition.phoneNumber()))
                .orderBy(customer.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory
                .select(customer.count())
                .from(customer)
                .where(
                        customer.deletedAt.isNull(),
                        containsName(condition.name()),
                        containsPhoneNumber(condition.phoneNumber()));

        return PageableExecutionUtils.getPage(contents, pageable, countQuery::fetchOne);
    }

    private BooleanExpression containsName(String name) {
        return StringUtils.hasText(name) ? customer.name.contains(name) : null;
    }

    private BooleanExpression containsPhoneNumber(String phoneNumber) {
        return StringUtils.hasText(phoneNumber) ? customer.phoneNumber.contains(phoneNumber) : null;
    }
}
