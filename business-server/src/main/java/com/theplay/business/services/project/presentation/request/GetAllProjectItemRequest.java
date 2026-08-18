package com.theplay.business.services.project.presentation.request;

import com.theplay.business.services.project.domain.ProjectItemStatus;

public record GetAllProjectItemRequest(
        Long projectId,

        Long providerJobId,

        ProjectItemStatus status
) {
}
