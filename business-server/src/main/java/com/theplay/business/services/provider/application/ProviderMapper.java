package com.theplay.business.services.provider.application;

import com.theplay.business.services.provider.application.dto.GetAllProviderDto;
import com.theplay.business.services.provider.application.dto.RegisterProviderDto;
import com.theplay.business.services.provider.domain.Provider;
import com.theplay.business.services.provider.domain.ProviderSearchCondition;
import org.springframework.stereotype.Component;

@Component
public class ProviderMapper {

    Provider mapFrom(RegisterProviderDto dto) {
        return new Provider(
                dto.name(),
                dto.category(),
                dto.managerName(),
                dto.phoneNumber());
    }

    ProviderSearchCondition mapFrom(GetAllProviderDto dto) {
        return new ProviderSearchCondition(
                dto.name(),
                dto.category());
    }
}
