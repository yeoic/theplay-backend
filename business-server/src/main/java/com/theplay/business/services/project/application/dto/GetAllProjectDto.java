package com.theplay.business.services.project.application.dto;

import com.theplay.business.services.project.domain.ProjectStatus;
import java.time.LocalDate;
import org.springframework.data.domain.Pageable;

public record GetAllProjectDto(String name, Long customerId, ProjectStatus status, LocalDate performanceDateFrom, LocalDate performanceDateTo, Pageable pageable) {
}
