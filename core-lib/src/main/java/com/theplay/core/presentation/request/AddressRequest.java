package com.theplay.core.presentation.request;

import com.theplay.core.domain.Address;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AddressRequest(
        @NotBlank(message = "우편번호를 입력해주세요.")
        @Size(max = 30, message = "우편번호는 30자를 넘을 수 없습니다.")
        String zipCode,

        @NotBlank(message = "시/도를 입력해주세요.")
        @Size(max = 30, message = "시/도는 30자를 넘을 수 없습니다.")
        String regionDepth1,

        @NotBlank(message = "시/군/구를 입력해주세요.")
        @Size(max = 30, message = "시/군/구는 30자를 넘을 수 없습니다.")
        String regionDepth2,

        @NotBlank(message = "읍/면/동을 입력해주세요.")
        @Size(max = 30, message = "읍/면/동은 30자를 넘을 수 없습니다.")
        String regionDepth3,

        @Size(max = 150, message = "상세 주소는 150자를 넘을 수 없습니다.")
        String addressDetail,

        @NotBlank(message = "도로명 주소를 입력해주세요.")
        @Size(max = 150, message = "도로명 주소는 150자를 넘을 수 없습니다.")
        String roadAddress,

        @NotBlank(message = "지번 주소를 입력해주세요.")
        @Size(max = 150, message = "지번 주소는 150자를 넘을 수 없습니다.")
        String jibunAddress,

        @NotNull(message = "위도를 입력해주세요.")
        Double latitude,

        @NotNull(message = "경도를 입력해주세요.")
        Double longitude
) {

    public Address toAddress() {
        return new Address(zipCode, regionDepth1, regionDepth2, regionDepth3, addressDetail,
                roadAddress, jibunAddress, latitude, longitude);
    }
}
