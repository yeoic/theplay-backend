package com.theplay.business.services.asset.application;

import com.theplay.business.services.asset.application.exception.AssetNotFoundException;
import com.theplay.business.services.asset.application.resource.GetAssetResource;
import com.theplay.business.services.asset.domain.AssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GetAssetService {

    private final AssetRepository assetRepository;

    @Transactional(readOnly = true)
    public GetAssetResource get(long id) {
        return assetRepository.findById(id)
                .map(GetAssetResource::from)
                .orElseThrow(() -> new AssetNotFoundException(id));
    }
}
