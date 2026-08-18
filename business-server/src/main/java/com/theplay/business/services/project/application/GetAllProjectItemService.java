package com.theplay.business.services.project.application;

import com.theplay.business.services.project.application.dto.GetAllProjectItemDto;
import com.theplay.business.services.project.application.resource.GetProjectItemResource;
import com.theplay.business.services.project.domain.ProjectItemRepository;
import com.theplay.core.presentation.response.PageResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GetAllProjectItemService {

    private final ProjectItemRepository projectItemRepository;
    private final ProjectItemMapper projectItemMapper;

    @Transactional(readOnly = true)
    public PageResource<GetProjectItemResource> getAll(GetAllProjectItemDto dto) {
        return PageResource.of(
                projectItemRepository.findAll(projectItemMapper.mapFrom(dto), dto.pageable()),
                GetProjectItemResource::from);
    }
}
