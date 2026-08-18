package com.theplay.business.services.project.application;

import com.theplay.business.services.project.application.exception.ProjectItemNotFoundException;
import com.theplay.business.services.project.domain.ProjectItem;
import com.theplay.business.services.project.domain.ProjectItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteProjectItemService {

    private final ProjectItemRepository projectItemRepository;

    @Transactional
    public void delete(long id) {
        ProjectItem projectItem = projectItemRepository.findById(id)
                .orElseThrow(() -> new ProjectItemNotFoundException(id));
        projectItemRepository.delete(projectItem);
    }
}
