package com.theplay.business.services.provider.presentation;

import com.theplay.business.services.provider.application.dto.RegisterProviderDto;
import com.theplay.business.services.provider.presentation.request.RegisterProviderRequest;
import org.springframework.stereotype.Component;

@Component
public class RegisterProviderDtoMapper {

    public RegisterProviderDto mapFrom(RegisterProviderRequest request) {
        return new RegisterProviderDto(
                request.name(),
                request.category(),
                request.managerName(),
                request.phoneNumber());
    }
}
