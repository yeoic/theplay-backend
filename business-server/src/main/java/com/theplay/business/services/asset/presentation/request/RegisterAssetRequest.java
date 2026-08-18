package com.theplay.business.services.asset.presentation.request;

import com.theplay.business.services.asset.domain.AssetCategory;
import com.theplay.business.services.asset.domain.AssetStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegisterAssetRequest(
        @NotBlank(message = "자산명을(를) 입력해주세요.")
        @Size(max = 50, message = "자산명은(는) 50자를 넘을 수 없습니다.")
        String name,

        @NotNull(message = "자산 분류을(를) 입력해주세요.")
        AssetCategory category,

        @NotNull(message = "자산 상태을(를) 입력해주세요.")
        AssetStatus status,

        @Size(max = 50, message = "관리번호은(는) 50자를 넘을 수 없습니다.")
        String serialNumber,

        @NotNull(message = "보관 업무공간을(를) 입력해주세요.")
        Long workspaceId
) {
}
