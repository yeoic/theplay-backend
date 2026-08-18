package com.theplay.business.services.venue.application.dto;

import com.theplay.core.domain.Address;

public record RegisterVenueDto(String name, Address address, int seatCount, boolean outdoor) {
}
