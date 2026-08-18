package com.theplay.business.services.venue.presentation.request;

import com.theplay.core.presentation.request.AddressRequest;

public class RegisterVenueRequestFixture {

    public static AddressRequest anAddressRequest() {
        return new AddressRequest(
                "12775", "경기", "광주시", "남한산성면", null,
                "경기 광주시 남한산성면 남한산성로 731", "경기 광주시 남한산성면 산성리 523", 37.4786, 127.1810);
    }

    public static RegisterVenueRequest aRegisterVenueRequest() {
        return new RegisterVenueRequest("남한산성 야외무대", anAddressRequest(), 500, true);
    }
}
