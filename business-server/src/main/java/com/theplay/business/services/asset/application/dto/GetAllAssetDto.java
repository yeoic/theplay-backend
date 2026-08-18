package com.theplay.business.services.asset.application.dto;

import com.theplay.business.services.asset.domain.AssetCategory;
import com.theplay.business.services.asset.domain.AssetStatus;
import org.springframework.data.domain.Pageable;

public record GetAllAssetDto(String name, AssetCategory category, AssetStatus status, Long workspaceId, Pageable pageable) {
}
