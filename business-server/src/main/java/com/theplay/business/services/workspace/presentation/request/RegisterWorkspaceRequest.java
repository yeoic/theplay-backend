package com.theplay.business.services.workspace.presentation.request;

import com.theplay.business.services.workspace.domain.WorkspaceType;
import com.theplay.core.presentation.request.AddressRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegisterWorkspaceRequest(
        @NotBlank(message = "업무공간명을(를) 입력해주세요.")
        @Size(max = 50, message = "업무공간명은(는) 50자를 넘을 수 없습니다.")
        String name,

        @NotNull(message = "업무공간 구분을(를) 입력해주세요.")
        WorkspaceType type,

        @Valid
        AddressRequest address
) {
}
