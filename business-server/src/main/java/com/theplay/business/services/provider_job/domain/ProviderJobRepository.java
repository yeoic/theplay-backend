package com.theplay.business.services.provider_job.domain;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProviderJobRepository {

    ProviderJob save(ProviderJob providerJob);

    Optional<ProviderJob> findById(long id);

    Page<ProviderJob> findAll(ProviderJobSearchCondition condition, Pageable pageable);

    void delete(ProviderJob providerJob);
}
