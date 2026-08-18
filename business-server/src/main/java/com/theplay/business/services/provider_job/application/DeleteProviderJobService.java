package com.theplay.business.services.provider_job.application;

import com.theplay.business.services.provider_job.application.exception.ProviderJobNotFoundException;
import com.theplay.business.services.provider_job.domain.ProviderJob;
import com.theplay.business.services.provider_job.domain.ProviderJobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteProviderJobService {

    private final ProviderJobRepository providerJobRepository;

    @Transactional
    public void delete(long id) {
        ProviderJob providerJob = providerJobRepository.findById(id)
                .orElseThrow(() -> new ProviderJobNotFoundException(id));
        providerJobRepository.delete(providerJob);
    }
}
