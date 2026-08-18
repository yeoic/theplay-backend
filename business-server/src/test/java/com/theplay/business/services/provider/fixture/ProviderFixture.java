package com.theplay.business.services.provider.fixture;

import com.theplay.business.services.provider.application.resource.GetProviderResource;
import com.theplay.business.services.provider.domain.Provider;
import com.theplay.business.services.provider.domain.ProviderCategory;

public class ProviderFixture {

    public static Provider.ProviderBuilder aProvider() {
        return Provider.builder()
                .id(1L)
                .name("청춘마이크 밴드")
                .category(ProviderCategory.PERFORMANCE)
                .managerName("박팀장")
                .phoneNumber("010-0000-0000");
    }

    public static GetProviderResource aGetProviderResource() {
        return GetProviderResource.from(aProvider().build());
    }
}
