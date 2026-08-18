package com.theplay.business.services.provider.presentation.request;

import com.theplay.business.services.provider.domain.ProviderCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegisterProviderRequest(
        @NotBlank(message = "공급사명을(를) 입력해주세요.")
        @Size(max = 50, message = "공급사명은(는) 50자를 넘을 수 없습니다.")
        String name,

        @NotNull(message = "공급 분야을(를) 입력해주세요.")
        ProviderCategory category,

        @Size(max = 30, message = "담당자명은(는) 30자를 넘을 수 없습니다.")
        String managerName,

        @NotBlank(message = "연락처을(를) 입력해주세요.")
        @Size(max = 20, message = "연락처은(는) 20자를 넘을 수 없습니다.")
        String phoneNumber
) {
}
