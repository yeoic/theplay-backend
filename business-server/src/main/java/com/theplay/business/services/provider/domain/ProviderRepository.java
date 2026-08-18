package com.theplay.business.services.provider.domain;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProviderRepository {

    Provider save(Provider provider);

    Optional<Provider> findById(long id);

    Page<Provider> findAll(ProviderSearchCondition condition, Pageable pageable);

    void delete(Provider provider);
}
