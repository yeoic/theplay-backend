package com.theplay.business.services.provider.application.dto;

import com.theplay.business.services.provider.domain.ProviderCategory;

public record RegisterProviderDto(String name, ProviderCategory category, String managerName, String phoneNumber) {
}
