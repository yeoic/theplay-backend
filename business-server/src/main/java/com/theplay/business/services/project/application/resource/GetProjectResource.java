package com.theplay.business.services.project.application.resource;

import com.theplay.business.services.project.domain.Project;
import com.theplay.business.services.project.domain.ProjectStatus;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record GetProjectResource(long id, String name, Long customerId, ProjectStatus status, LocalDate performanceDate, Long amount, Long venueId,
                                 LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {

    public static GetProjectResource from(Project project) {
        return new GetProjectResource(
                project.getId(),
                project.getName(),
                project.getCustomerId(),
                project.getStatus(),
                project.getPerformanceDate(),
                project.getAmount(),
                project.getVenueId(),
                project.getCreatedAt(),
                project.getUpdatedAt(),
                project.getDeletedAt());
    }
}
