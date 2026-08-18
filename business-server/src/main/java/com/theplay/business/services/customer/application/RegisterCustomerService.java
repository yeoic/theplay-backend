package com.theplay.business.services.customer.application;

import com.theplay.business.services.customer.application.dto.RegisterCustomerDto;
import com.theplay.business.services.customer.application.resource.RegisterCustomerResource;
import com.theplay.business.services.customer.domain.Customer;
import com.theplay.business.services.customer.domain.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterCustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Transactional
    public RegisterCustomerResource register(RegisterCustomerDto dto) {
        Customer customer = customerRepository.save(customerMapper.mapFrom(dto));
        return new RegisterCustomerResource(customer.getId());
    }
}
