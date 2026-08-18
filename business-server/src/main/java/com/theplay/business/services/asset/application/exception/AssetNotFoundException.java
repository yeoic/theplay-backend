package com.theplay.business.services.asset.application.exception;

import com.theplay.core.application.NotFoundException;

public class AssetNotFoundException extends NotFoundException {

    public AssetNotFoundException(long id) {
        super("assetId", "id가 %d인 자산을(를) 찾을 수 없습니다.".formatted(id));
    }
}
