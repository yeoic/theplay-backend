package com.theplay.business.services.provider_job.presentation.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record RegisterProviderJobRequest(
        @NotBlank(message = "서비스명을(를) 입력해주세요.")
        @Size(max = 100, message = "서비스명은(는) 100자를 넘을 수 없습니다.")
        String name,

        @NotNull(message = "공급사을(를) 입력해주세요.")
        Long providerId,

        @PositiveOrZero(message = "단가은(는) 0 이상이어야 합니다.")
        Long price,

        @PositiveOrZero(message = "소요 시간(분)은(는) 0 이상이어야 합니다.")
        int durationMinutes,

        @Positive(message = "투입 인원 수은(는) 1 이상이어야 합니다.")
        int headcount,

        @Size(max = 500, message = "서비스 소개은(는) 500자를 넘을 수 없습니다.")
        String description
) {
}
