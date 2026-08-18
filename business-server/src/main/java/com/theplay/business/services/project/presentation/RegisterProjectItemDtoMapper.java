package com.theplay.business.services.project.presentation;

import com.theplay.business.services.project.application.dto.RegisterProjectItemDto;
import com.theplay.business.services.project.presentation.request.RegisterProjectItemRequest;
import org.springframework.stereotype.Component;

@Component
public class RegisterProjectItemDtoMapper {

    public RegisterProjectItemDto mapFrom(RegisterProjectItemRequest request) {
        return new RegisterProjectItemDto(
                request.projectId(),
                request.providerJobId(),
                request.billingAmount(),
                request.status(),
                request.executionStatus(),
                request.paymentStatus(),
                request.settlementStatus());
    }
}
