package com.theplay.business.services.project.application;

import com.theplay.business.services.project.application.dto.GetAllProjectDto;
import com.theplay.business.services.project.application.resource.GetProjectResource;
import com.theplay.business.services.project.domain.ProjectRepository;
import com.theplay.core.presentation.response.PageResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GetAllProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Transactional(readOnly = true)
    public PageResource<GetProjectResource> getAll(GetAllProjectDto dto) {
        return PageResource.of(
                projectRepository.findAll(projectMapper.mapFrom(dto), dto.pageable()),
                GetProjectResource::from);
    }
}
