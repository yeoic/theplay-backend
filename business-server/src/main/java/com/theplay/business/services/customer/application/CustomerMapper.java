package com.theplay.business.services.customer.application;

import com.theplay.business.services.customer.application.dto.GetAllCustomerDto;
import com.theplay.business.services.customer.application.dto.RegisterCustomerDto;
import com.theplay.business.services.customer.domain.Customer;
import com.theplay.business.services.customer.domain.CustomerSearchCondition;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    Customer mapFrom(RegisterCustomerDto dto) {
        return new Customer(
                dto.name(),
                dto.managerName(),
                dto.phoneNumber(),
                dto.email());
    }

    CustomerSearchCondition mapFrom(GetAllCustomerDto dto) {
        return new CustomerSearchCondition(
                dto.name(),
                dto.phoneNumber());
    }
}
