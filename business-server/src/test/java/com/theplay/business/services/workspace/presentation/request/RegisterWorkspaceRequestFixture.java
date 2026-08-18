package com.theplay.business.services.workspace.presentation.request;

import com.theplay.business.services.workspace.domain.WorkspaceType;
import com.theplay.core.presentation.request.AddressRequest;

public class RegisterWorkspaceRequestFixture {

    public static AddressRequest anAddressRequest() {
        return new AddressRequest(
                "12738", "경기", "광주시", "양벌동", "2층 창고동",
                "경기 광주시 양벌로 100", "경기 광주시 양벌동 100-1", 37.4295, 127.2557);
    }

    public static RegisterWorkspaceRequest aRegisterWorkspaceRequest() {
        return new RegisterWorkspaceRequest("양벌동 장비창고", WorkspaceType.WAREHOUSE, anAddressRequest());
    }
}
