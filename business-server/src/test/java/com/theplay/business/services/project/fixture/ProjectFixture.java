package com.theplay.business.services.project.fixture;

import com.theplay.business.services.project.application.resource.GetProjectResource;
import com.theplay.business.services.project.domain.Project;
import com.theplay.business.services.project.domain.ProjectStatus;
import java.time.LocalDate;

public class ProjectFixture {

    public static Project.ProjectBuilder aProject() {
        return Project.builder()
                .id(1L)
                .name("겨울 축제 초청 공연")
                .customerId(1L)
                .status(ProjectStatus.REQUESTED)
                .performanceDate(LocalDate.of(2026, 12, 1))
                .amount(5_000_000L);
    }

    public static GetProjectResource aGetProjectResource() {
        return GetProjectResource.from(aProject().build());
    }
}
