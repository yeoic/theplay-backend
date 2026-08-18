package com.theplay.business.services.customer.presentation;

import com.theplay.business.services.customer.application.dto.GetAllCustomerDto;
import com.theplay.business.services.customer.presentation.request.GetAllCustomerRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class GetAllCustomerDtoMapper {

    public GetAllCustomerDto mapFrom(GetAllCustomerRequest request, Pageable pageable) {
        return new GetAllCustomerDto(
                request.name(),
                request.phoneNumber(),
                pageable);
    }
}
