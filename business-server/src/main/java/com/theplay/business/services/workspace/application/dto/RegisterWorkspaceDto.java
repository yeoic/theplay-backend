package com.theplay.business.services.workspace.application.dto;

import com.theplay.business.services.workspace.domain.WorkspaceType;
import com.theplay.core.domain.Address;

public record RegisterWorkspaceDto(String name, WorkspaceType type, Address address) {
}
