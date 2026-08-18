package com.theplay.business.services.asset.fixture;

import com.theplay.business.services.asset.application.resource.GetAssetResource;
import com.theplay.business.services.asset.domain.Asset;
import com.theplay.business.services.asset.domain.AssetCategory;
import com.theplay.business.services.asset.domain.AssetStatus;

public class AssetFixture {

    public static Asset.AssetBuilder aAsset() {
        return Asset.builder()
                .id(1L)
                .name("무빙라이트 세트")
                .category(AssetCategory.LIGHTING)
                .status(AssetStatus.AVAILABLE)
                .serialNumber("LT-001")
                .workspaceId(1L);
    }

    public static GetAssetResource aGetAssetResource() {
        return GetAssetResource.from(aAsset().build());
    }
}
