package com.theplay.business.services.venue.domain;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VenueRepository {

    Venue save(Venue venue);

    Optional<Venue> findById(long id);

    Page<Venue> findAll(VenueSearchCondition condition, Pageable pageable);

    void delete(Venue venue);
}
