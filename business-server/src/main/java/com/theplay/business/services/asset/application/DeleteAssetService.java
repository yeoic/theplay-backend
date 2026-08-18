package com.theplay.business.services.asset.application;

import com.theplay.business.services.asset.application.exception.AssetNotFoundException;
import com.theplay.business.services.asset.domain.Asset;
import com.theplay.business.services.asset.domain.AssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteAssetService {

    private final AssetRepository assetRepository;

    @Transactional
    public void delete(long id) {
        Asset asset = assetRepository.findById(id)
                .orElseThrow(() -> new AssetNotFoundException(id));
        assetRepository.delete(asset);
    }
}
