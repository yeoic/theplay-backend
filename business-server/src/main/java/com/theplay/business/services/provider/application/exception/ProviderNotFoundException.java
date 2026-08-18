package com.theplay.business.services.provider.application.exception;

import com.theplay.core.application.NotFoundException;

public class ProviderNotFoundException extends NotFoundException {

    public ProviderNotFoundException(long id) {
        super("providerId", "id가 %d인 공급사을(를) 찾을 수 없습니다.".formatted(id));
    }
}
