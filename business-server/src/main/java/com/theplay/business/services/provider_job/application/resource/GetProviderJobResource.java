package com.theplay.business.services.provider_job.application.resource;

import com.theplay.business.services.provider_job.domain.ProviderJob;
import java.time.LocalDateTime;

public record GetProviderJobResource(long id, String name, Long providerId, Long price, int durationMinutes,
                                     int headcount, String description,
                                     LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {

    public static GetProviderJobResource from(ProviderJob providerJob) {
        return new GetProviderJobResource(
                providerJob.getId(),
                providerJob.getName(),
                providerJob.getProviderId(),
                providerJob.getPrice(),
                providerJob.getDurationMinutes(),
                providerJob.getHeadcount(),
                providerJob.getDescription(),
                providerJob.getCreatedAt(),
                providerJob.getUpdatedAt(),
                providerJob.getDeletedAt());
    }
}
