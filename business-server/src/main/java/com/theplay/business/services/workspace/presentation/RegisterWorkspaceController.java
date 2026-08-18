package com.theplay.business.services.workspace.presentation;

import com.theplay.business.services.workspace.application.RegisterWorkspaceService;
import com.theplay.business.services.workspace.application.resource.RegisterWorkspaceResource;
import com.theplay.business.services.workspace.presentation.request.RegisterWorkspaceRequest;
import com.theplay.core.presentation.response.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/workspaces")
@RequiredArgsConstructor
public class RegisterWorkspaceController {

    private final RegisterWorkspaceService registerWorkspaceService;
    private final RegisterWorkspaceDtoMapper registerWorkspaceDtoMapper;

    @PostMapping
    public ResponseEntity<Response<RegisterWorkspaceResource>> register(
            @Valid @RequestBody RegisterWorkspaceRequest request) {
        return Response.created(registerWorkspaceService.register(registerWorkspaceDtoMapper.mapFrom(request)));
    }
}
