package com.theplay.business.services.provider.application;

import com.theplay.business.services.provider.application.exception.ProviderNotFoundException;
import com.theplay.business.services.provider.application.resource.GetProviderResource;
import com.theplay.business.services.provider.domain.ProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GetProviderService {

    private final ProviderRepository providerRepository;

    @Transactional(readOnly = true)
    public GetProviderResource get(long id) {
        return providerRepository.findById(id)
                .map(GetProviderResource::from)
                .orElseThrow(() -> new ProviderNotFoundException(id));
    }
}
