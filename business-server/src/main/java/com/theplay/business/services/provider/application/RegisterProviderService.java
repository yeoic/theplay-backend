package com.theplay.business.services.provider.application;

import com.theplay.business.services.provider.application.dto.RegisterProviderDto;
import com.theplay.business.services.provider.application.resource.RegisterProviderResource;
import com.theplay.business.services.provider.domain.Provider;
import com.theplay.business.services.provider.domain.ProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterProviderService {

    private final ProviderRepository providerRepository;
    private final ProviderMapper providerMapper;

    @Transactional
    public RegisterProviderResource register(RegisterProviderDto dto) {
        Provider provider = providerRepository.save(providerMapper.mapFrom(dto));
        return new RegisterProviderResource(provider.getId());
    }
}
