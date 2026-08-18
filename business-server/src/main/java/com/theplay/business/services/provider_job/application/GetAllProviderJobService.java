package com.theplay.business.services.provider_job.application;

import com.theplay.business.services.provider_job.application.dto.GetAllProviderJobDto;
import com.theplay.business.services.provider_job.application.resource.GetProviderJobResource;
import com.theplay.business.services.provider_job.domain.ProviderJobRepository;
import com.theplay.core.presentation.response.PageResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GetAllProviderJobService {

    private final ProviderJobRepository providerJobRepository;
    private final ProviderJobMapper providerJobMapper;

    @Transactional(readOnly = true)
    public PageResource<GetProviderJobResource> getAll(GetAllProviderJobDto dto) {
        return PageResource.of(
                providerJobRepository.findAll(providerJobMapper.mapFrom(dto), dto.pageable()),
                GetProviderJobResource::from);
    }
}
