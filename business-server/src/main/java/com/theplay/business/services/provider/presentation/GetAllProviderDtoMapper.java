package com.theplay.business.services.provider.presentation;

import com.theplay.business.services.provider.application.dto.GetAllProviderDto;
import com.theplay.business.services.provider.presentation.request.GetAllProviderRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class GetAllProviderDtoMapper {

    public GetAllProviderDto mapFrom(GetAllProviderRequest request, Pageable pageable) {
        return new GetAllProviderDto(
                request.name(),
                request.category(),
                pageable);
    }
}
