package com.theplay.business.services.workspace.presentation;

import com.theplay.business.services.workspace.application.GetWorkspaceService;
import com.theplay.business.services.workspace.application.resource.GetWorkspaceResource;
import com.theplay.core.presentation.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/workspaces")
@RequiredArgsConstructor
public class GetWorkspaceController {

    private final GetWorkspaceService getWorkspaceService;

    @GetMapping("/{id}")
    public ResponseEntity<Response<GetWorkspaceResource>> get(@PathVariable long id) {
        return Response.ok(getWorkspaceService.get(id));
    }
}
