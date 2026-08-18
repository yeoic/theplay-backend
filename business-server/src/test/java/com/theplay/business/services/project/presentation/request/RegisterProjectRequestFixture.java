package com.theplay.business.services.project.presentation.request;

import com.theplay.business.services.project.domain.ProjectStatus;
import com.theplay.business.services.project.presentation.request.RegisterProjectRequest;
import java.time.LocalDate;

public class RegisterProjectRequestFixture {

    public static RegisterProjectRequest aRegisterProjectRequest() {
        return new RegisterProjectRequest(
                "겨울 축제 초청 공연", 1L, ProjectStatus.REQUESTED, LocalDate.of(2026, 12, 1), 5_000_000L, null);
    }
}
