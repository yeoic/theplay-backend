package com.theplay.business.services.project.presentation;

import com.theplay.business.services.project.application.dto.RegisterProjectDto;
import com.theplay.business.services.project.presentation.request.RegisterProjectRequest;
import org.springframework.stereotype.Component;

@Component
public class RegisterProjectDtoMapper {

    public RegisterProjectDto mapFrom(RegisterProjectRequest request) {
        return new RegisterProjectDto(
                request.name(),
                request.customerId(),
                request.status(),
                request.performanceDate(),
                request.amount(),
                request.venueId());
    }
}
