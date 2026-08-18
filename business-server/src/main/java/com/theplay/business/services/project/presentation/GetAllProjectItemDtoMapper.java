package com.theplay.business.services.project.presentation;

import com.theplay.business.services.project.application.dto.GetAllProjectItemDto;
import com.theplay.business.services.project.presentation.request.GetAllProjectItemRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class GetAllProjectItemDtoMapper {

    public GetAllProjectItemDto mapFrom(GetAllProjectItemRequest request, Pageable pageable) {
        return new GetAllProjectItemDto(
                request.projectId(),
                request.providerJobId(),
                request.status(),
                pageable);
    }
}
