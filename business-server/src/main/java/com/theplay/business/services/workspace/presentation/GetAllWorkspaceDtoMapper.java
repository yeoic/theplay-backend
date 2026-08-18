package com.theplay.business.services.workspace.presentation;

import com.theplay.business.services.workspace.application.dto.GetAllWorkspaceDto;
import com.theplay.business.services.workspace.presentation.request.GetAllWorkspaceRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class GetAllWorkspaceDtoMapper {

    public GetAllWorkspaceDto mapFrom(GetAllWorkspaceRequest request, Pageable pageable) {
        return new GetAllWorkspaceDto(
                request.name(),
                request.type(),
                pageable);
    }
}
