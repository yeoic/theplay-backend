package com.theplay.business.services.workspace.presentation.request;

import com.theplay.business.services.workspace.domain.WorkspaceType;

public record GetAllWorkspaceRequest(
        String name,

        WorkspaceType type
) {
}
