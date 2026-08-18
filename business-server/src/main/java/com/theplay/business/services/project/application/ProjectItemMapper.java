package com.theplay.business.services.project.application;

import com.theplay.business.services.project.application.dto.GetAllProjectItemDto;
import com.theplay.business.services.project.application.dto.RegisterProjectItemDto;
import com.theplay.business.services.project.domain.ProjectItem;
import com.theplay.business.services.project.domain.ProjectItemSearchCondition;
import com.theplay.business.services.provider.domain.Provider;
import com.theplay.business.services.provider_job.domain.ProviderJob;
import org.springframework.stereotype.Component;

@Component
public class ProjectItemMapper {
    ProjectItem mapFrom(RegisterProjectItemDto dto, ProviderJob providerJob, Provider provider) {
        return new ProjectItem(
                dto.projectId(),
                providerJob.getId(),
                providerJob.getName(),
                provider.getName(),
                dto.billingAmount(),
                providerJob.getPrice(),
                providerJob.getHeadcount(),
                dto.status(),
                dto.executionStatus(),
                dto.paymentStatus(),
                dto.settlementStatus());
    }

    ProjectItemSearchCondition mapFrom(GetAllProjectItemDto dto) {
        return new ProjectItemSearchCondition(
                dto.projectId(),
                dto.providerJobId(),
                dto.status());
    }
}
