package com.theplay.business.services.provider.application.resource;

import com.theplay.business.services.provider.domain.Provider;
import java.time.LocalDateTime;
import com.theplay.business.services.provider.domain.ProviderCategory;

public record GetProviderResource(long id, String name, ProviderCategory category, String managerName, String phoneNumber,
                                  LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {

    public static GetProviderResource from(Provider provider) {
        return new GetProviderResource(
                provider.getId(),
                provider.getName(),
                provider.getCategory(),
                provider.getManagerName(),
                provider.getPhoneNumber(),
                provider.getCreatedAt(),
                provider.getUpdatedAt(),
                provider.getDeletedAt());
    }
}
