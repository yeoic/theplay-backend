package com.theplay.business.services.workspace.application;

import com.theplay.business.services.workspace.application.dto.GetAllWorkspaceDto;
import com.theplay.business.services.workspace.application.dto.RegisterWorkspaceDto;
import com.theplay.business.services.workspace.domain.Workspace;
import com.theplay.business.services.workspace.domain.WorkspaceSearchCondition;
import org.springframework.stereotype.Component;

@Component
public class WorkspaceMapper {

    Workspace mapFrom(RegisterWorkspaceDto dto) {
        return new Workspace(
                dto.name(),
                dto.type(),
                dto.address());
    }

    WorkspaceSearchCondition mapFrom(GetAllWorkspaceDto dto) {
        return new WorkspaceSearchCondition(
                dto.name(),
                dto.type());
    }
}
