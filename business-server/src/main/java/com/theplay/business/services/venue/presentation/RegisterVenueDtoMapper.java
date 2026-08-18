package com.theplay.business.services.venue.presentation;

import com.theplay.business.services.venue.application.dto.RegisterVenueDto;
import com.theplay.business.services.venue.presentation.request.RegisterVenueRequest;
import org.springframework.stereotype.Component;

@Component
public class RegisterVenueDtoMapper {

    public RegisterVenueDto mapFrom(RegisterVenueRequest request) {
        return new RegisterVenueDto(
                request.name(),
                request.address().toAddress(),
                request.seatCount(),
                request.outdoor());
    }
}
