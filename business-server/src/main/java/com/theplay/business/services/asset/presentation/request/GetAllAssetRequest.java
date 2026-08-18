package com.theplay.business.services.asset.presentation.request;

import com.theplay.business.services.asset.domain.AssetCategory;
import com.theplay.business.services.asset.domain.AssetStatus;

public record GetAllAssetRequest(
        String name,

        AssetCategory category,

        AssetStatus status,

        Long workspaceId
) {
}
