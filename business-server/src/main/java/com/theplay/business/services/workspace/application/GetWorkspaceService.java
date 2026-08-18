package com.theplay.business.services.workspace.application;

import com.theplay.business.services.workspace.application.exception.WorkspaceNotFoundException;
import com.theplay.business.services.workspace.application.resource.GetWorkspaceResource;
import com.theplay.business.services.workspace.domain.WorkspaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GetWorkspaceService {

    private final WorkspaceRepository workspaceRepository;

    @Transactional(readOnly = true)
    public GetWorkspaceResource get(long id) {
        return workspaceRepository.findById(id)
                .map(GetWorkspaceResource::from)
                .orElseThrow(() -> new WorkspaceNotFoundException(id));
    }
}
