package com.theplay.business.services.venue.application.exception;

import com.theplay.core.application.NotFoundException;

public class VenueNotFoundException extends NotFoundException {

    public VenueNotFoundException(long id) {
        super("venueId", "id가 %d인 공연장을(를) 찾을 수 없습니다.".formatted(id));
    }
}
