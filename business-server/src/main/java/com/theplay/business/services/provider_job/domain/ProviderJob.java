package com.theplay.business.services.provider_job.domain;

import com.theplay.core.domain.AggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "provider_job")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProviderJob extends AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "provider_id", nullable = false)
    private Long providerId;

    @Column(name = "price", nullable = true)
    private Long price;

    @Column(name = "duration_minutes", nullable = false)
    private int durationMinutes;

    @Column(name = "headcount", nullable = false)
    private int headcount;

    @Column(name = "description", nullable = true, length = 500)
    private String description;

    public ProviderJob(String name, Long providerId, Long price, int durationMinutes, int headcount,
                       String description) {
        this.name = name;
        this.providerId = providerId;
        this.price = price;
        this.durationMinutes = durationMinutes;
        this.headcount = headcount;
        this.description = description;
    }

    @Builder
    private ProviderJob(Long id, String name, Long providerId, Long price, int durationMinutes, int headcount,
                        String description) {
        this.id = id;
        this.name = name;
        this.providerId = providerId;
        this.price = price;
        this.durationMinutes = durationMinutes;
        this.headcount = headcount;
        this.description = description;
    }
}
