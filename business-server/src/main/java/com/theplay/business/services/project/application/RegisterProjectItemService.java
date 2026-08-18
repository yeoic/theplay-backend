package com.theplay.business.services.project.application;

import com.theplay.business.services.project.application.dto.RegisterProjectItemDto;
import com.theplay.business.services.project.application.exception.ProjectNotFoundException;
import com.theplay.business.services.project.application.resource.RegisterProjectItemResource;
import com.theplay.business.services.project.domain.ProjectItem;
import com.theplay.business.services.project.domain.ProjectItemRepository;
import com.theplay.business.services.project.domain.ProjectRepository;
import com.theplay.business.services.provider.application.exception.ProviderNotFoundException;
import com.theplay.business.services.provider.domain.Provider;
import com.theplay.business.services.provider.domain.ProviderRepository;
import com.theplay.business.services.provider_job.application.exception.ProviderJobNotFoundException;
import com.theplay.business.services.provider_job.domain.ProviderJob;
import com.theplay.business.services.provider_job.domain.ProviderJobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@RequiredArgsConstructor
public class RegisterProjectItemService {

    private final ProjectItemRepository projectItemRepository;
    private final ProjectRepository projectRepository;
    private final ProviderJobRepository providerJobRepository;
    private final ProviderRepository providerRepository;
    private final ProjectItemMapper projectItemMapper;

    @Transactional
    public RegisterProjectItemResource register(RegisterProjectItemDto dto) {
        projectRepository.findById(dto.projectId())
                .orElseThrow(() -> new ProjectNotFoundException(dto.projectId()));

        ProviderJob providerJob = providerJobRepository.findById(dto.providerJobId())
                .orElseThrow(() -> new ProviderJobNotFoundException(dto.providerJobId()));
        Provider provider = providerRepository.findById(providerJob.getProviderId())
                .orElseThrow(() -> new ProviderNotFoundException(providerJob.getProviderId()));

        ProjectItem projectItem = projectItemRepository.save(
                projectItemMapper.mapFrom(dto, providerJob, provider));
        return new RegisterProjectItemResource(projectItem.getId());
    }
}
