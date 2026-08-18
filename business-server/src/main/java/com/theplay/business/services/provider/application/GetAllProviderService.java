package com.theplay.business.services.provider.application;

import com.theplay.business.services.provider.application.dto.GetAllProviderDto;
import com.theplay.business.services.provider.application.resource.GetProviderResource;
import com.theplay.business.services.provider.domain.ProviderRepository;
import com.theplay.core.presentation.response.PageResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GetAllProviderService {

    private final ProviderRepository providerRepository;
    private final ProviderMapper providerMapper;

    @Transactional(readOnly = true)
    public PageResource<GetProviderResource> getAll(GetAllProviderDto dto) {
        return PageResource.of(
                providerRepository.findAll(providerMapper.mapFrom(dto), dto.pageable()),
                GetProviderResource::from);
    }
}
