package com.theplay.business.services.project.presentation;

import com.theplay.business.services.project.application.GetAllProjectService;
import com.theplay.business.services.project.application.resource.GetProjectResource;
import com.theplay.business.services.project.presentation.request.GetAllProjectRequest;
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
@RequestMapping("/api/v1/projects")
@RequiredArgsConstructor
public class GetAllProjectController {

    private final GetAllProjectService getAllProjectService;
    private final GetAllProjectDtoMapper getAllProjectDtoMapper;

    @GetMapping
    public ResponseEntity<Response<PageResource<GetProjectResource>>> getAll(
            @ModelAttribute GetAllProjectRequest request,
            @PageableDefault(size = 20) Pageable pageable) {
        return Response.ok(getAllProjectService.getAll(getAllProjectDtoMapper.mapFrom(request, pageable)));
    }
}
