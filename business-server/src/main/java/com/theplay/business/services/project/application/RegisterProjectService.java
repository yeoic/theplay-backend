package com.theplay.business.services.project.application;

import com.theplay.business.services.project.application.dto.RegisterProjectDto;
import com.theplay.business.services.project.application.resource.RegisterProjectResource;
import com.theplay.business.services.project.domain.Project;
import com.theplay.business.services.project.domain.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Transactional
    public RegisterProjectResource register(RegisterProjectDto dto) {
        Project project = projectRepository.save(projectMapper.mapFrom(dto));
        return new RegisterProjectResource(project.getId());
    }
}
