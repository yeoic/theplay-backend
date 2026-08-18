package com.theplay.business.services.project.presentation.request;

import com.theplay.business.services.project.domain.ProjectItemExecutionStatus;
import com.theplay.business.services.project.domain.ProjectItemPaymentStatus;
import com.theplay.business.services.project.domain.ProjectItemSettlementStatus;
import com.theplay.business.services.project.domain.ProjectItemStatus;

public class RegisterProjectItemRequestFixture {

    public static RegisterProjectItemRequest aRegisterProjectItemRequest() {
        return new RegisterProjectItemRequest(
                1L, 1L, 4_000_000L, ProjectItemStatus.WAITING, ProjectItemExecutionStatus.PROPOSED,
                ProjectItemPaymentStatus.PAYMENT_PENDING,
                ProjectItemSettlementStatus.SETTLEMENT_PENDING);
    }
}
