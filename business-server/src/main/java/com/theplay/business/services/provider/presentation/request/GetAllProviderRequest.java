package com.theplay.business.services.provider.presentation.request;

import com.theplay.business.services.provider.domain.ProviderCategory;

public record GetAllProviderRequest(
        String name,

        ProviderCategory category
) {
}
