package com.theplay.business.services.workspace.presentation;

import com.theplay.business.services.workspace.application.dto.RegisterWorkspaceDto;
import com.theplay.business.services.workspace.presentation.request.RegisterWorkspaceRequest;
import org.springframework.stereotype.Component;

@Component
public class RegisterWorkspaceDtoMapper {

    public RegisterWorkspaceDto mapFrom(RegisterWorkspaceRequest request) {
        return new RegisterWorkspaceDto(
                request.name(),
                request.type(),
                request.address() == null ? null : request.address().toAddress());
    }
}
