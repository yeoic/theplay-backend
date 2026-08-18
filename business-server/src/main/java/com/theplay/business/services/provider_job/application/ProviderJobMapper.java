package com.theplay.business.services.provider_job.application;

import com.theplay.business.services.provider_job.application.dto.GetAllProviderJobDto;
import com.theplay.business.services.provider_job.application.dto.RegisterProviderJobDto;
import com.theplay.business.services.provider_job.domain.ProviderJob;
import com.theplay.business.services.provider_job.domain.ProviderJobSearchCondition;
import org.springframework.stereotype.Component;

@Component
public class ProviderJobMapper {

    ProviderJob mapFrom(RegisterProviderJobDto dto) {
        return new ProviderJob(
                dto.name(),
                dto.providerId(),
                dto.price(),
                dto.durationMinutes(),
                dto.headcount(),
                dto.description());
    }

    ProviderJobSearchCondition mapFrom(GetAllProviderJobDto dto) {
        return new ProviderJobSearchCondition(
                dto.name(),
                dto.providerId());
    }
}
