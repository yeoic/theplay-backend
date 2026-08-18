package com.theplay.business.services.asset.application;

import com.theplay.business.services.asset.application.dto.GetAllAssetDto;
import com.theplay.business.services.asset.application.resource.GetAssetResource;
import com.theplay.business.services.asset.domain.AssetRepository;
import com.theplay.core.presentation.response.PageResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GetAllAssetService {

    private final AssetRepository assetRepository;
    private final AssetMapper assetMapper;

    @Transactional(readOnly = true)
    public PageResource<GetAssetResource> getAll(GetAllAssetDto dto) {
        return PageResource.of(
                assetRepository.findAll(assetMapper.mapFrom(dto), dto.pageable()),
                GetAssetResource::from);
    }
}
