package com.theplay.business.services.asset.application.dto;

import com.theplay.business.services.asset.domain.AssetCategory;
import com.theplay.business.services.asset.domain.AssetStatus;

public record RegisterAssetDto(String name, AssetCategory category, AssetStatus status, String serialNumber, Long workspaceId) {
}
