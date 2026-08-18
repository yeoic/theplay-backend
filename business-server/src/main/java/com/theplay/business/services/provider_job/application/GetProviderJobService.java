package com.theplay.business.services.provider_job.application;

import com.theplay.business.services.provider_job.application.exception.ProviderJobNotFoundException;
import com.theplay.business.services.provider_job.application.resource.GetProviderJobResource;
import com.theplay.business.services.provider_job.domain.ProviderJobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GetProviderJobService {

    private final ProviderJobRepository providerJobRepository;

    @Transactional(readOnly = true)
    public GetProviderJobResource get(long id) {
        return providerJobRepository.findById(id)
                .map(GetProviderJobResource::from)
                .orElseThrow(() -> new ProviderJobNotFoundException(id));
    }
}
