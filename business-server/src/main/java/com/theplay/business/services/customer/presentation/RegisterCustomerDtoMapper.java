package com.theplay.business.services.customer.presentation;

import com.theplay.business.services.customer.application.dto.RegisterCustomerDto;
import com.theplay.business.services.customer.presentation.request.RegisterCustomerRequest;
import org.springframework.stereotype.Component;

@Component
public class RegisterCustomerDtoMapper {

    public RegisterCustomerDto mapFrom(RegisterCustomerRequest request) {
        return new RegisterCustomerDto(
                request.name(),
                request.managerName(),
                request.phoneNumber(),
                request.email());
    }
}
