package com.theplay.business.services.customer.presentation.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterCustomerRequest(
        @NotBlank(message = "고객명을(를) 입력해주세요.")
        @Size(max = 50, message = "고객명은(는) 50자를 넘을 수 없습니다.")
        String name,

        @Size(max = 30, message = "담당자명은(는) 30자를 넘을 수 없습니다.")
        String managerName,

        @NotBlank(message = "연락처을(를) 입력해주세요.")
        @Size(max = 20, message = "연락처은(는) 20자를 넘을 수 없습니다.")
        String phoneNumber,

        @Size(max = 100, message = "이메일은(는) 100자를 넘을 수 없습니다.")
        String email
) {
}
