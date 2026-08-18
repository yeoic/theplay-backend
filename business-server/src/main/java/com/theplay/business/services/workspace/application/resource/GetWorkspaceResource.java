package com.theplay.business.services.workspace.application.resource;

import com.theplay.business.services.workspace.domain.Workspace;
import com.theplay.business.services.workspace.domain.WorkspaceType;
import com.theplay.core.presentation.response.AddressResource;
import java.time.LocalDateTime;

public record GetWorkspaceResource(long id, String name, WorkspaceType type, AddressResource address,
                                   LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {

    public static GetWorkspaceResource from(Workspace workspace) {
        return new GetWorkspaceResource(
                workspace.getId(),
                workspace.getName(),
                workspace.getType(),
                AddressResource.from(workspace.getAddress()),
                workspace.getCreatedAt(),
                workspace.getUpdatedAt(),
                workspace.getDeletedAt());
    }
}
