package com.theplay.business.services.venue.presentation.request;

import com.theplay.core.presentation.request.AddressRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record RegisterVenueRequest(
        @NotBlank(message = "공연장명을(를) 입력해주세요.")
        @Size(max = 50, message = "공연장명은(는) 50자를 넘을 수 없습니다.")
        String name,

        @NotNull(message = "주소를 입력해주세요.")
        @Valid
        AddressRequest address,

        @PositiveOrZero(message = "객석 수은(는) 0 이상이어야 합니다.")
        int seatCount,

        boolean outdoor
) {
}
