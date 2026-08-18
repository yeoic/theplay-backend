package com.theplay.business.services.workspace.application;

import com.theplay.business.services.workspace.application.dto.RegisterWorkspaceDto;
import com.theplay.business.services.workspace.application.resource.RegisterWorkspaceResource;
import com.theplay.business.services.workspace.domain.Workspace;
import com.theplay.business.services.workspace.domain.WorkspaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterWorkspaceService {

    private final WorkspaceRepository workspaceRepository;
    private final WorkspaceMapper workspaceMapper;

    @Transactional
    public RegisterWorkspaceResource register(RegisterWorkspaceDto dto) {
        Workspace workspace = workspaceRepository.save(workspaceMapper.mapFrom(dto));
        return new RegisterWorkspaceResource(workspace.getId());
    }
}
