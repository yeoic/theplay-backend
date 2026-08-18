package com.theplay.business.services.workspace.application.dto;

import com.theplay.business.services.workspace.domain.WorkspaceType;
import org.springframework.data.domain.Pageable;

public record GetAllWorkspaceDto(String name, WorkspaceType type, Pageable pageable) {
}
