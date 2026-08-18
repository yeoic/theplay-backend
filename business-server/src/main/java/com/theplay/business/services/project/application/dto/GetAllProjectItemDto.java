package com.theplay.business.services.project.application.dto;

import com.theplay.business.services.project.domain.ProjectItemExecutionStatus;
import com.theplay.business.services.project.domain.ProjectItemPaymentStatus;
import com.theplay.business.services.project.domain.ProjectItemStatus;
import org.springframework.data.domain.Pageable;

public record GetAllProjectItemDto(Long projectId, Long providerJobId, ProjectItemStatus status, Pageable pageable) {
}
