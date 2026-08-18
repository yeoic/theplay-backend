package com.theplay.business.services.project.presentation.request;

import com.theplay.business.services.project.domain.ProjectItemExecutionStatus;
import com.theplay.business.services.project.domain.ProjectItemPaymentStatus;
import com.theplay.business.services.project.domain.ProjectItemSettlementStatus;
import com.theplay.business.services.project.domain.ProjectItemStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record RegisterProjectItemRequest(
        @NotNull(message = "프로젝트을(를) 입력해주세요.")
        Long projectId,

        @NotNull(message = "제공 서비스을(를) 입력해주세요.")
        Long providerJobId,

        @NotNull(message = "청구 비용을(를) 입력해주세요.")
        @PositiveOrZero(message = "청구 비용은(는) 0 이상이어야 합니다.")
        Long billingAmount,

        @NotNull(message = "종합 상태을(를) 입력해주세요.")
        ProjectItemStatus status,

        @NotNull(message = "실행 상태을(를) 입력해주세요.")
        ProjectItemExecutionStatus executionStatus,

        @NotNull(message = "결제 상태을(를) 입력해주세요.")
        ProjectItemPaymentStatus paymentStatus,

        @NotNull(message = "정산 상태을(를) 입력해주세요.")
        ProjectItemSettlementStatus settlementStatus
) {
}
