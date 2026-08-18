package com.theplay.core.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode
public class Address {

    @Column(name = "zip_code", length = 30)
    private String zipCode;

    @Column(name = "region_depth1", length = 30)
    private String regionDepth1;

    @Column(name = "region_depth2", length = 30)
    private String regionDepth2;

    @Column(name = "region_depth3", length = 30)
    private String regionDepth3;

    @Column(name = "address_detail", length = 150)
    private String addressDetail;

    @Column(name = "road_address", length = 150)
    private String roadAddress;

    @Column(name = "jibun_address", length = 150)
    private String jibunAddress;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;
}
