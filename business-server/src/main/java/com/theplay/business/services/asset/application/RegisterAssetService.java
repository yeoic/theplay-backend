package com.theplay.business.services.asset.application;

import com.theplay.business.services.asset.application.dto.RegisterAssetDto;
import com.theplay.business.services.asset.application.resource.RegisterAssetResource;
import com.theplay.business.services.asset.domain.Asset;
import com.theplay.business.services.asset.domain.AssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterAssetService {

    private final AssetRepository assetRepository;
    private final AssetMapper assetMapper;

    @Transactional
    public RegisterAssetResource register(RegisterAssetDto dto) {
        Asset asset = assetRepository.save(assetMapper.mapFrom(dto));
        return new RegisterAssetResource(asset.getId());
    }
}
