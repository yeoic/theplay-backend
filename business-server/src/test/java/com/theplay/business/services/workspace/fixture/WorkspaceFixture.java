package com.theplay.business.services.workspace.fixture;

import com.theplay.business.services.workspace.application.resource.GetWorkspaceResource;
import com.theplay.business.services.workspace.domain.Workspace;
import com.theplay.business.services.workspace.domain.WorkspaceType;
import com.theplay.core.domain.Address;

public class WorkspaceFixture {

    public static Address anAddress() {
        return Address.builder()
                .zipCode("12738")
                .regionDepth1("경기")
                .regionDepth2("광주시")
                .regionDepth3("양벌동")
                .addressDetail("2층 창고동")
                .roadAddress("경기 광주시 양벌로 100")
                .jibunAddress("경기 광주시 양벌동 100-1")
                .latitude(37.4295)
                .longitude(127.2557)
                .build();
    }

    public static Workspace.WorkspaceBuilder aWarehouse() {
        return Workspace.builder()
                .id(1L)
                .name("양벌동 장비창고")
                .type(WorkspaceType.WAREHOUSE)
                .address(anAddress());
    }

    public static GetWorkspaceResource aGetWorkspaceResource() {
        return GetWorkspaceResource.from(aWarehouse().build());
    }
}
