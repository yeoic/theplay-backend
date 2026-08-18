package com.theplay.business.services.provider_job.application;

import com.theplay.business.services.provider_job.application.dto.RegisterProviderJobDto;
import com.theplay.business.services.provider_job.application.resource.RegisterProviderJobResource;
import com.theplay.business.services.provider_job.domain.ProviderJob;
import com.theplay.business.services.provider_job.domain.ProviderJobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterProviderJobService {

    private final ProviderJobRepository providerJobRepository;
    private final ProviderJobMapper providerJobMapper;

    @Transactional
    public RegisterProviderJobResource register(RegisterProviderJobDto dto) {
        ProviderJob providerJob = providerJobRepository.save(providerJobMapper.mapFrom(dto));
        return new RegisterProviderJobResource(providerJob.getId());
    }
}
