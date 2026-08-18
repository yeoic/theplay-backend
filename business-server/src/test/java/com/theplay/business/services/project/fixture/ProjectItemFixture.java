package com.theplay.business.services.project.fixture;

import com.theplay.business.services.project.application.resource.GetProjectItemResource;
import com.theplay.business.services.project.domain.ProjectItem;
import com.theplay.business.services.project.domain.ProjectItemExecutionStatus;
import com.theplay.business.services.project.domain.ProjectItemPaymentStatus;
import com.theplay.business.services.project.domain.ProjectItemSettlementStatus;
import com.theplay.business.services.project.domain.ProjectItemStatus;

public class ProjectItemFixture {

    public static ProjectItem.ProjectItemBuilder aProjectItem() {
        return ProjectItem.builder()
                .id(1L)
                .projectId(1L)
                .providerJobId(1L)
                .jobName("넌버벌 퍼포먼스 '비트'")
                .providerName("청춘마이크 밴드")
                .price(3_000_000L)
                .headcount(4)
                .status(ProjectItemStatus.WAITING)
                .executionStatus(ProjectItemExecutionStatus.PROPOSED)
                .paymentStatus(ProjectItemPaymentStatus.PAYMENT_PENDING)
                .settlementStatus(ProjectItemSettlementStatus.SETTLEMENT_PENDING);
    }

    public static GetProjectItemResource aGetProjectItemResource() {
        return GetProjectItemResource.from(aProjectItem().build());
    }
}
