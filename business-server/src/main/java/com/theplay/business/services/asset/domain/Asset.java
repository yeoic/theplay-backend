package com.theplay.business.services.asset.domain;

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
@Table(name = "asset")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Asset extends AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false, length = 20)
    private AssetCategory category;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private AssetStatus status;

    @Column(name = "serial_number", nullable = true, length = 50)
    private String serialNumber;

    @Column(name = "workspace_id", nullable = false)
    private Long workspaceId;

    public Asset(String name, AssetCategory category, AssetStatus status, String serialNumber, Long workspaceId) {
        this.name = name;
        this.category = category;
        this.status = status;
        this.serialNumber = serialNumber;
        this.workspaceId = workspaceId;
    }

    @Builder
    private Asset(Long id, String name, AssetCategory category, AssetStatus status, String serialNumber, Long workspaceId) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.status = status;
        this.serialNumber = serialNumber;
        this.workspaceId = workspaceId;
    }
}
