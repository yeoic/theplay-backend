package com.theplay.business.services.asset.application;

import com.theplay.business.services.asset.application.dto.GetAllAssetDto;
import com.theplay.business.services.asset.application.dto.RegisterAssetDto;
import com.theplay.business.services.asset.domain.Asset;
import com.theplay.business.services.asset.domain.AssetSearchCondition;
import org.springframework.stereotype.Component;

@Component
public class AssetMapper {

    Asset mapFrom(RegisterAssetDto dto) {
        return new Asset(
                dto.name(),
                dto.category(),
                dto.status(),
                dto.serialNumber(),
                dto.workspaceId());
    }

    AssetSearchCondition mapFrom(GetAllAssetDto dto) {
        return new AssetSearchCondition(
                dto.name(),
                dto.category(),
                dto.status(),
                dto.workspaceId());
    }
}
