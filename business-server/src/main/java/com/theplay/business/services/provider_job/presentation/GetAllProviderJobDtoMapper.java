package com.theplay.business.services.provider_job.presentation;

import com.theplay.business.services.provider_job.application.dto.GetAllProviderJobDto;
import com.theplay.business.services.provider_job.presentation.request.GetAllProviderJobRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class GetAllProviderJobDtoMapper {

    public GetAllProviderJobDto mapFrom(GetAllProviderJobRequest request, Pageable pageable) {
        return new GetAllProviderJobDto(
                request.name(),
                request.providerId(),
                pageable);
    }
}
