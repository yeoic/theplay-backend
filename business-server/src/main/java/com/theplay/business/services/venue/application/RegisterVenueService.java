package com.theplay.business.services.venue.application;

import com.theplay.business.services.venue.application.dto.RegisterVenueDto;
import com.theplay.business.services.venue.application.resource.RegisterVenueResource;
import com.theplay.business.services.venue.domain.Venue;
import com.theplay.business.services.venue.domain.VenueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterVenueService {

    private final VenueRepository venueRepository;
    private final VenueMapper venueMapper;

    @Transactional
    public RegisterVenueResource register(RegisterVenueDto dto) {
        Venue venue = venueRepository.save(venueMapper.mapFrom(dto));
        return new RegisterVenueResource(venue.getId());
    }
}
