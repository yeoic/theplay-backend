package com.theplay.business.services.asset.presentation.request;

import com.theplay.business.services.asset.domain.AssetCategory;
import com.theplay.business.services.asset.domain.AssetStatus;
import com.theplay.business.services.asset.presentation.request.RegisterAssetRequest;

public class RegisterAssetRequestFixture {

    public static RegisterAssetRequest aRegisterAssetRequest() {
        return new RegisterAssetRequest(
                "무빙라이트 세트", AssetCategory.LIGHTING, AssetStatus.AVAILABLE, "LT-001", 1L);
    }
}
