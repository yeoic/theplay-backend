package com.theplay.business.services.project.application;

import com.theplay.business.services.project.application.exception.ProjectItemNotFoundException;
import com.theplay.business.services.project.application.resource.GetProjectItemResource;
import com.theplay.business.services.project.domain.ProjectItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GetProjectItemService {

    private final ProjectItemRepository projectItemRepository;

    @Transactional(readOnly = true)
    public GetProjectItemResource get(long id) {
        return projectItemRepository.findById(id)
                .map(GetProjectItemResource::from)
                .orElseThrow(() -> new ProjectItemNotFoundException(id));
    }
}
