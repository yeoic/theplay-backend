package com.theplay.business.services.venue.application.resource;

import com.theplay.business.services.venue.domain.Venue;
import com.theplay.core.presentation.response.AddressResource;
import java.time.LocalDateTime;

public record GetVenueResource(long id, String name, AddressResource address, int seatCount, boolean outdoor,
                               LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {

    public static GetVenueResource from(Venue venue) {
        return new GetVenueResource(
                venue.getId(),
                venue.getName(),
                AddressResource.from(venue.getAddress()),
                venue.getSeatCount(),
                venue.isOutdoor(),
                venue.getCreatedAt(),
                venue.getUpdatedAt(),
                venue.getDeletedAt());
    }
}
