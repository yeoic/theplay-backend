package com.theplay.business.services.provider.application;

import com.theplay.business.services.provider.application.exception.ProviderNotFoundException;
import com.theplay.business.services.provider.domain.Provider;
import com.theplay.business.services.provider.domain.ProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteProviderService {

    private final ProviderRepository providerRepository;

    @Transactional
    public void delete(long id) {
        Provider provider = providerRepository.findById(id)
                .orElseThrow(() -> new ProviderNotFoundException(id));
        providerRepository.delete(provider);
    }
}
