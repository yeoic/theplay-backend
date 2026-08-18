package com.theplay.business.services.project.presentation;

import com.theplay.business.services.project.application.dto.GetAllProjectDto;
import com.theplay.business.services.project.presentation.request.GetAllProjectRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class GetAllProjectDtoMapper {

    public GetAllProjectDto mapFrom(GetAllProjectRequest request, Pageable pageable) {
        return new GetAllProjectDto(
                request.name(),
                request.customerId(),
                request.status(),
                request.performanceDateFrom(),
                request.performanceDateTo(),
                pageable);
    }
}
