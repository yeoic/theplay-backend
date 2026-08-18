package com.theplay.business.services.project.application.dto;

import com.theplay.business.services.project.domain.ProjectStatus;
import java.time.LocalDate;

public record RegisterProjectDto(String name, Long customerId, ProjectStatus status, LocalDate performanceDate, Long amount, Long venueId) {
}
