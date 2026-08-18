package com.theplay.business.services.provider_job.application.dto;

import org.springframework.data.domain.Pageable;

public record GetAllProviderJobDto(String name, Long providerId, Pageable pageable) {
}
