package com.theplay.business.services.asset.application.resource;

import com.theplay.business.services.asset.domain.Asset;
import java.time.LocalDateTime;
import com.theplay.business.services.asset.domain.AssetCategory;
import com.theplay.business.services.asset.domain.AssetStatus;

public record GetAssetResource(long id, String name, AssetCategory category, AssetStatus status, String serialNumber, Long workspaceId,
                               LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {

    public static GetAssetResource from(Asset asset) {
        return new GetAssetResource(
                asset.getId(),
                asset.getName(),
                asset.getCategory(),
                asset.getStatus(),
                asset.getSerialNumber(),
                asset.getWorkspaceId(),
                asset.getCreatedAt(),
                asset.getUpdatedAt(),
                asset.getDeletedAt());
    }
}
