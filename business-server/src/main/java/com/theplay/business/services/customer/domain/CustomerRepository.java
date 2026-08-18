package com.theplay.business.services.customer.domain;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerRepository {

    Customer save(Customer customer);

    Optional<Customer> findById(long id);

    Page<Customer> findAll(CustomerSearchCondition condition, Pageable pageable);

    void delete(Customer customer);
}
