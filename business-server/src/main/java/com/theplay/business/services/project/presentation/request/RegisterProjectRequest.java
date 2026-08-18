package com.theplay.business.services.project.presentation.request;

import com.theplay.business.services.project.domain.ProjectStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record RegisterProjectRequest(
        @NotBlank(message = "공연 건명을(를) 입력해주세요.")
        @Size(max = 100, message = "공연 건명은(는) 100자를 넘을 수 없습니다.")
        String name,

        @NotNull(message = "고객을(를) 입력해주세요.")
        Long customerId,

        @NotNull(message = "프로젝트 상태을(를) 입력해주세요.")
        ProjectStatus status,

        @NotNull(message = "공연일을(를) 입력해주세요.")
        LocalDate performanceDate,

        Long amount,

        Long venueId
) {
}
