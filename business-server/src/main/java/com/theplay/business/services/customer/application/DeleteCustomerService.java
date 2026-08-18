package com.theplay.business.services.customer.application;

import com.theplay.business.services.customer.application.exception.CustomerNotFoundException;
import com.theplay.business.services.customer.domain.Customer;
import com.theplay.business.services.customer.domain.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteCustomerService {

    private final CustomerRepository customerRepository;

    @Transactional
    public void delete(long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        customerRepository.delete(customer);
    }
}
