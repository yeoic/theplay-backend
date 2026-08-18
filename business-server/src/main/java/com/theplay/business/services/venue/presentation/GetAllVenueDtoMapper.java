package com.theplay.business.services.venue.presentation;

import com.theplay.business.services.venue.application.dto.GetAllVenueDto;
import com.theplay.business.services.venue.presentation.request.GetAllVenueRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class GetAllVenueDtoMapper {

    public GetAllVenueDto mapFrom(GetAllVenueRequest request, Pageable pageable) {
        return new GetAllVenueDto(
                request.name(),
                request.outdoor(),
                pageable);
    }
}
