package com.theplay.business.services.project.presentation.request;

import com.theplay.business.services.project.domain.ProjectStatus;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

public record GetAllProjectRequest(
        String name,

        Long customerId,

        ProjectStatus status,

        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        LocalDate performanceDateFrom,

        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        LocalDate performanceDateTo
) {
}
