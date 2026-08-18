package com.theplay.business.services.project.application.exception;

import com.theplay.core.application.NotFoundException;

public class ProjectNotFoundException extends NotFoundException {

    public ProjectNotFoundException(long id) {
        super("projectId", "id가 %d인 프로젝트을(를) 찾을 수 없습니다.".formatted(id));
    }
}
