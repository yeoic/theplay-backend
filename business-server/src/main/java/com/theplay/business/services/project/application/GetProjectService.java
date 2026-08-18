package com.theplay.business.services.project.application;

import com.theplay.business.services.project.application.exception.ProjectNotFoundException;
import com.theplay.business.services.project.application.resource.GetProjectResource;
import com.theplay.business.services.project.domain.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GetProjectService {

    private final ProjectRepository projectRepository;

    @Transactional(readOnly = true)
    public GetProjectResource get(long id) {
        return projectRepository.findById(id)
                .map(GetProjectResource::from)
                .orElseThrow(() -> new ProjectNotFoundException(id));
    }
}
