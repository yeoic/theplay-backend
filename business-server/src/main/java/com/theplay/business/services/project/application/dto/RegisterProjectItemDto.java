package com.theplay.business.services.project.application.dto;

import com.theplay.business.services.project.domain.ProjectItemExecutionStatus;
import com.theplay.business.services.project.domain.ProjectItemPaymentStatus;
import com.theplay.business.services.project.domain.ProjectItemSettlementStatus;
import com.theplay.business.services.project.domain.ProjectItemStatus;

public record RegisterProjectItemDto(Long projectId, Long providerJobId, Long billingAmount,
                                     ProjectItemStatus status,
                                     ProjectItemExecutionStatus executionStatus,
                                     ProjectItemPaymentStatus paymentStatus,
                                     ProjectItemSettlementStatus settlementStatus) {
}
