package com.theplay.business.services.customer.application.exception;

import com.theplay.core.application.NotFoundException;

public class CustomerNotFoundException extends NotFoundException {

    public CustomerNotFoundException(long id) {
        super("customerId", "id가 %d인 고객을(를) 찾을 수 없습니다.".formatted(id));
    }
}
