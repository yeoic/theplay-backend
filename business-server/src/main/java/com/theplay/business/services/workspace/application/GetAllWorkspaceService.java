package com.theplay.business.services.workspace.application;

import com.theplay.business.services.workspace.application.dto.GetAllWorkspaceDto;
import com.theplay.business.services.workspace.application.resource.GetWorkspaceResource;
import com.theplay.business.services.workspace.domain.WorkspaceRepository;
import com.theplay.core.presentation.response.PageResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GetAllWorkspaceService {

    private final WorkspaceRepository workspaceRepository;
    private final WorkspaceMapper workspaceMapper;

    @Transactional(readOnly = true)
    public PageResource<GetWorkspaceResource> getAll(GetAllWorkspaceDto dto) {
        return PageResource.of(
                workspaceRepository.findAll(workspaceMapper.mapFrom(dto), dto.pageable()),
                GetWorkspaceResource::from);
    }
}
