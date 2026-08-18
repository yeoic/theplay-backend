package com.theplay.business.services.project.application;

import com.theplay.business.services.project.application.dto.GetAllProjectDto;
import com.theplay.business.services.project.application.dto.RegisterProjectDto;
import com.theplay.business.services.project.domain.Project;
import com.theplay.business.services.project.domain.ProjectSearchCondition;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    Project mapFrom(RegisterProjectDto dto) {
        return new Project(
                dto.name(),
                dto.customerId(),
                dto.status(),
                dto.performanceDate(),
                dto.amount(),
                dto.venueId());
    }

    ProjectSearchCondition mapFrom(GetAllProjectDto dto) {
        return new ProjectSearchCondition(
                dto.name(),
                dto.customerId(),
                dto.status(),
                dto.performanceDateFrom(),
                dto.performanceDateTo());
    }
}
