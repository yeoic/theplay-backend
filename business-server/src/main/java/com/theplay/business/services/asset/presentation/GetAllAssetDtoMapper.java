package com.theplay.business.services.asset.presentation;

import com.theplay.business.services.asset.application.dto.GetAllAssetDto;
import com.theplay.business.services.asset.presentation.request.GetAllAssetRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class GetAllAssetDtoMapper {

    public GetAllAssetDto mapFrom(GetAllAssetRequest request, Pageable pageable) {
        return new GetAllAssetDto(
                request.name(),
                request.category(),
                request.status(),
                request.workspaceId(),
                pageable);
    }
}
