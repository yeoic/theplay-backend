package com.theplay.core.presentation.response;

import com.theplay.core.domain.Address;

public record AddressResource(String zipCode, String regionDepth1, String regionDepth2, String regionDepth3,
                              String addressDetail, String roadAddress, String jibunAddress,
                              Double latitude, Double longitude) {

    public static AddressResource from(Address address) {
        if (address == null) {
            return null;
        }
        return new AddressResource(
                address.getZipCode(),
                address.getRegionDepth1(),
                address.getRegionDepth2(),
                address.getRegionDepth3(),
                address.getAddressDetail(),
                address.getRoadAddress(),
                address.getJibunAddress(),
                address.getLatitude(),
                address.getLongitude());
    }
}
