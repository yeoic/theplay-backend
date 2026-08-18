package com.theplay.business.services.provider.presentation.request;

import com.theplay.business.services.provider.domain.ProviderCategory;
import com.theplay.business.services.provider.presentation.request.RegisterProviderRequest;

public class RegisterProviderRequestFixture {

    public static RegisterProviderRequest aRegisterProviderRequest() {
        return new RegisterProviderRequest(
                "청춘마이크 밴드", ProviderCategory.PERFORMANCE, "박팀장", "010-0000-0000");
    }
}
