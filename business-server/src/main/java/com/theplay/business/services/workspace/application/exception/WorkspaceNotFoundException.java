package com.theplay.business.services.workspace.application.exception;

import com.theplay.core.application.NotFoundException;

public class WorkspaceNotFoundException extends NotFoundException {

    public WorkspaceNotFoundException(long id) {
        super("workspaceId", "id가 %d인 업무공간을(를) 찾을 수 없습니다.".formatted(id));
    }
}
