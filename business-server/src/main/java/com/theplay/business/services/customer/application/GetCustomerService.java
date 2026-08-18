package com.theplay.business.services.customer.application;

import com.theplay.business.services.customer.application.exception.CustomerNotFoundException;
import com.theplay.business.services.customer.application.resource.GetCustomerResource;
import com.theplay.business.services.customer.domain.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GetCustomerService {

    private final CustomerRepository customerRepository;

    @Transactional(readOnly = true)
    public GetCustomerResource get(long id) {
        return customerRepository.findById(id)
                .map(GetCustomerResource::from)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }
}
