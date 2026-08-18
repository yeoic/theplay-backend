package com.theplay.business.services.project.domain;

import com.theplay.core.domain.AggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "project_item")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProjectItem extends AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "project_id", nullable = false)
    private Long projectId;

    @Column(name = "provider_job_id", nullable = false)
    private Long providerJobId;

    @Column(name = "job_name", nullable = false, length = 100)
    private String jobName;

    @Column(name = "provider_name", nullable = false, length = 50)
    private String providerName;

    @Column(name = "price")
    private Long price;

    @Column(name = "headcount", nullable = false)
    private int headcount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private ProjectItemStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "execution_status", nullable = false, length = 20)
    private ProjectItemExecutionStatus executionStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status", nullable = false, length = 20)
    private ProjectItemPaymentStatus paymentStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "settlement_status", nullable = false, length = 20)
    private ProjectItemSettlementStatus settlementStatus;

    public ProjectItem(Long projectId, Long providerJobId, String jobName, String providerName, Long price,
                       int headcount, ProjectItemStatus status, ProjectItemExecutionStatus executionStatus,
                       ProjectItemPaymentStatus paymentStatus,
                       ProjectItemSettlementStatus settlementStatus) {
        this.projectId = projectId;
        this.providerJobId = providerJobId;
        this.jobName = jobName;
        this.providerName = providerName;
        this.price = price;
        this.headcount = headcount;
        this.status = status;
        this.executionStatus = executionStatus;
        this.paymentStatus = paymentStatus;
        this.settlementStatus = settlementStatus;
    }

    @Builder
    private ProjectItem(Long id, Long projectId, Long providerJobId, String jobName, String providerName,
                        Long price, int headcount, ProjectItemStatus status,
                        ProjectItemExecutionStatus executionStatus, ProjectItemPaymentStatus paymentStatus,
                        ProjectItemSettlementStatus settlementStatus) {
        this.id = id;
        this.projectId = projectId;
        this.providerJobId = providerJobId;
        this.jobName = jobName;
        this.providerName = providerName;
        this.price = price;
        this.headcount = headcount;
        this.status = status;
        this.executionStatus = executionStatus;
        this.paymentStatus = paymentStatus;
        this.settlementStatus = settlementStatus;
    }
}
