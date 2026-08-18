package com.theplay.business.services.workspace.presentation;

import com.theplay.business.services.workspace.application.GetAllWorkspaceService;
import com.theplay.business.services.workspace.application.resource.GetWorkspaceResource;
import com.theplay.business.services.workspace.presentation.request.GetAllWorkspaceRequest;
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
@RequestMapping("/api/v1/workspaces")
@RequiredArgsConstructor
public class GetAllWorkspaceController {

    private final GetAllWorkspaceService getAllWorkspaceService;
    private final GetAllWorkspaceDtoMapper getAllWorkspaceDtoMapper;

    @GetMapping
    public ResponseEntity<Response<PageResource<GetWorkspaceResource>>> getAll(
            @ModelAttribute GetAllWorkspaceRequest request,
            @PageableDefault(size = 20) Pageable pageable) {
        return Response.ok(getAllWorkspaceService.getAll(getAllWorkspaceDtoMapper.mapFrom(request, pageable)));
    }
}
