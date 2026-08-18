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
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "project")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Project extends AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private ProjectStatus status;

    @Column(name = "performance_date", nullable = false)
    private LocalDate performanceDate;

    @Column(name = "amount", nullable = true)
    private Long amount;

    @Column(name = "venue_id", nullable = true)
    private Long venueId;

    public Project(String name, Long customerId, ProjectStatus status, LocalDate performanceDate, Long amount, Long venueId) {
        this.name = name;
        this.customerId = customerId;
        this.status = status;
        this.performanceDate = performanceDate;
        this.amount = amount;
        this.venueId = venueId;
    }

    @Builder
    private Project(Long id, String name, Long customerId, ProjectStatus status, LocalDate performanceDate, Long amount, Long venueId) {
        this.id = id;
        this.name = name;
        this.customerId = customerId;
        this.status = status;
        this.performanceDate = performanceDate;
        this.amount = amount;
        this.venueId = venueId;
    }
}
