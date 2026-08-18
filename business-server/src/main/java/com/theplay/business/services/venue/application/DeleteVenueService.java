package com.theplay.business.services.venue.application;

import com.theplay.business.services.venue.application.exception.VenueNotFoundException;
import com.theplay.business.services.venue.domain.Venue;
import com.theplay.business.services.venue.domain.VenueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteVenueService {

    private final VenueRepository venueRepository;

    @Transactional
    public void delete(long id) {
        Venue venue = venueRepository.findById(id)
                .orElseThrow(() -> new VenueNotFoundException(id));
        venueRepository.delete(venue);
    }
}
