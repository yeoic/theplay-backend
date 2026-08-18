package com.theplay.business.services.provider_job.application.exception;

import com.theplay.core.application.NotFoundException;

public class ProviderJobNotFoundException extends NotFoundException {

    public ProviderJobNotFoundException(long id) {
        super("providerJobId", "id가 %d인 제공 서비스을(를) 찾을 수 없습니다.".formatted(id));
    }
}
