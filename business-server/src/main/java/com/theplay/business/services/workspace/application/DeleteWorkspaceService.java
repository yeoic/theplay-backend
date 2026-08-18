package com.theplay.business.services.workspace.application;

import com.theplay.business.services.workspace.application.exception.WorkspaceNotFoundException;
import com.theplay.business.services.workspace.domain.Workspace;
import com.theplay.business.services.workspace.domain.WorkspaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteWorkspaceService {

    private final WorkspaceRepository workspaceRepository;

    @Transactional
    public void delete(long id) {
        Workspace workspace = workspaceRepository.findById(id)
                .orElseThrow(() -> new WorkspaceNotFoundException(id));
        workspaceRepository.delete(workspace);
    }
}
