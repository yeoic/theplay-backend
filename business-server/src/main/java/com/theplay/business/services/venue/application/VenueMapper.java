package com.theplay.business.services.venue.application;

import com.theplay.business.services.venue.application.dto.GetAllVenueDto;
import com.theplay.business.services.venue.application.dto.RegisterVenueDto;
import com.theplay.business.services.venue.domain.Venue;
import com.theplay.business.services.venue.domain.VenueSearchCondition;
import org.springframework.stereotype.Component;

@Component
public class VenueMapper {

    Venue mapFrom(RegisterVenueDto dto) {
        return new Venue(
                dto.name(),
                dto.address(),
                dto.seatCount(),
                dto.outdoor());
    }

    VenueSearchCondition mapFrom(GetAllVenueDto dto) {
        return new VenueSearchCondition(
                dto.name(),
                dto.outdoor());
    }
}
