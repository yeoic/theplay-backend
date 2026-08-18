package com.theplay.business.services.provider.application.dto;

import com.theplay.business.services.provider.domain.ProviderCategory;
import org.springframework.data.domain.Pageable;

public record GetAllProviderDto(String name, ProviderCategory category, Pageable pageable) {
}
