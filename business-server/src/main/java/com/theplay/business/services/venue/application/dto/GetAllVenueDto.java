package com.theplay.business.services.venue.application.dto;

import org.springframework.data.domain.Pageable;

public record GetAllVenueDto(String name, Boolean outdoor, Pageable pageable) {
}
