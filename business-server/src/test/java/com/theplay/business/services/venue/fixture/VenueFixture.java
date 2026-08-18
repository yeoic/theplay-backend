package com.theplay.business.services.venue.fixture;

import com.theplay.business.services.venue.application.resource.GetVenueResource;
import com.theplay.business.services.venue.domain.Venue;
import com.theplay.core.domain.Address;

public class VenueFixture {

    public static Address anAddress() {
        return Address.builder()
                .zipCode("12775")
                .regionDepth1("경기")
                .regionDepth2("광주시")
                .regionDepth3("남한산성면")
                .roadAddress("경기 광주시 남한산성면 남한산성로 731")
                .jibunAddress("경기 광주시 남한산성면 산성리 523")
                .latitude(37.4786)
                .longitude(127.1810)
                .build();
    }

    public static Venue.VenueBuilder aVenue() {
        return Venue.builder()
                .id(1L)
                .name("남한산성 야외무대")
                .address(anAddress())
                .seatCount(500)
                .outdoor(true);
    }

    public static GetVenueResource aGetVenueResource() {
        return GetVenueResource.from(aVenue().build());
    }
}
