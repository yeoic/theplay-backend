package com.theplay.business.services.project.application;

import com.theplay.business.services.project.application.exception.ProjectNotFoundException;
import com.theplay.business.services.project.domain.Project;
import com.theplay.business.services.project.domain.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteProjectService {

    private final ProjectRepository projectRepository;

    @Transactional
    public void delete(long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));
        projectRepository.delete(project);
    }
}
