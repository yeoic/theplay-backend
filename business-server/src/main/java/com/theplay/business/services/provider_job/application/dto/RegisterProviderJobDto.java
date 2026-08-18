package com.theplay.business.services.provider_job.application.dto;

public record RegisterProviderJobDto(String name, Long providerId, Long price, int durationMinutes,
                                     int headcount, String description) {
}
