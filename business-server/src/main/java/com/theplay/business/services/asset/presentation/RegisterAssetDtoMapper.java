package com.theplay.business.services.asset.presentation;

import com.theplay.business.services.asset.application.dto.RegisterAssetDto;
import com.theplay.business.services.asset.presentation.request.RegisterAssetRequest;
import org.springframework.stereotype.Component;

@Component
public class RegisterAssetDtoMapper {

    public RegisterAssetDto mapFrom(RegisterAssetRequest request) {
        return new RegisterAssetDto(
                request.name(),
                request.category(),
                request.status(),
                request.serialNumber(),
                request.workspaceId());
    }
}
