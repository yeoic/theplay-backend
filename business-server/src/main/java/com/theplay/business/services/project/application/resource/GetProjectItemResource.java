package com.theplay.business.services.project.application.resource;

import com.theplay.business.services.project.domain.ProjectItem;
import java.time.LocalDateTime;
import com.theplay.business.services.project.domain.ProjectItemExecutionStatus;
import com.theplay.business.services.project.domain.ProjectItemPaymentStatus;
import com.theplay.business.services.project.domain.ProjectItemSettlementStatus;
import com.theplay.business.services.project.domain.ProjectItemStatus;

public record GetProjectItemResource(long id, Long projectId, Long providerJobId, String jobName,
                                     String providerName, Long price, int headcount, ProjectItemStatus status,
                                     ProjectItemExecutionStatus executionStatus,
                                     ProjectItemPaymentStatus paymentStatus,
                                     ProjectItemSettlementStatus settlementStatus,
                                     LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {

    public static GetProjectItemResource from(ProjectItem projectItem) {
        return new GetProjectItemResource(
                projectItem.getId(),
                projectItem.getProjectId(),
                projectItem.getProviderJobId(),
                projectItem.getJobName(),
                projectItem.getProviderName(),
                projectItem.getPrice(),
                projectItem.getHeadcount(),
                projectItem.getStatus(),
                projectItem.getExecutionStatus(),
                projectItem.getPaymentStatus(),
                projectItem.getSettlementStatus(),
                projectItem.getCreatedAt(),
                projectItem.getUpdatedAt(),
                projectItem.getDeletedAt());
    }
}
