package com.theplay.business.services.project.presentation;

import com.theplay.business.services.project.application.GetAllProjectItemService;
import com.theplay.business.services.project.application.resource.GetProjectItemResource;
import com.theplay.business.services.project.presentation.request.GetAllProjectItemRequest;
import com.theplay.core.presentation.response.PageResource;
import com.theplay.core.presentation.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/project-items")
@RequiredArgsConstructor
public class GetAllProjectItemController {

    private final GetAllProjectItemService getAllProjectItemService;
    private final GetAllProjectItemDtoMapper getAllProjectItemDtoMapper;

    @GetMapping
    public ResponseEntity<Response<PageResource<GetProjectItemResource>>> getAll(
            @ModelAttribute GetAllProjectItemRequest request,
            @PageableDefault(size = 20) Pageable pageable) {
        return Response.ok(getAllProjectItemService.getAll(getAllProjectItemDtoMapper.mapFrom(request, pageable)));
    }
}
