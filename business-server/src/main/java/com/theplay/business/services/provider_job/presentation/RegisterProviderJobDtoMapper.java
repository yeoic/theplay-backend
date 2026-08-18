package com.theplay.business.services.provider_job.presentation;

import com.theplay.business.services.provider_job.application.dto.RegisterProviderJobDto;
import com.theplay.business.services.provider_job.presentation.request.RegisterProviderJobRequest;
import org.springframework.stereotype.Component;

@Component
public class RegisterProviderJobDtoMapper {

    public RegisterProviderJobDto mapFrom(RegisterProviderJobRequest request) {
        return new RegisterProviderJobDto(
                request.name(),
                request.providerId(),
                request.price(),
                request.durationMinutes(),
                request.headcount(),
                request.description());
    }
}
