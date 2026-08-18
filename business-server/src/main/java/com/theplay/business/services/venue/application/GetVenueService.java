package com.theplay.business.services.venue.application;

import com.theplay.business.services.venue.application.exception.VenueNotFoundException;
import com.theplay.business.services.venue.application.resource.GetVenueResource;
import com.theplay.business.services.venue.domain.VenueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GetVenueService {

    private final VenueRepository venueRepository;

    @Transactional(readOnly = true)
    public GetVenueResource get(long id) {
        return venueRepository.findById(id)
                .map(GetVenueResource::from)
                .orElseThrow(() -> new VenueNotFoundException(id));
    }
}
