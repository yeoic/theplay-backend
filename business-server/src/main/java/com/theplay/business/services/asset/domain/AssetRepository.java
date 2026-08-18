package com.theplay.business.services.asset.domain;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AssetRepository {

    Asset save(Asset asset);

    Optional<Asset> findById(long id);

    Page<Asset> findAll(AssetSearchCondition condition, Pageable pageable);

    void delete(Asset asset);
}
