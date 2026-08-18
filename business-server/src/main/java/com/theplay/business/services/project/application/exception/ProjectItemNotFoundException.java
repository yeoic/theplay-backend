package com.theplay.business.services.project.application.exception;

import com.theplay.core.application.NotFoundException;

public class ProjectItemNotFoundException extends NotFoundException {

    public ProjectItemNotFoundException(long id) {
        super("projectItemId", "id가 %d인 프로젝트 견적 항목을(를) 찾을 수 없습니다.".formatted(id));
    }
}
