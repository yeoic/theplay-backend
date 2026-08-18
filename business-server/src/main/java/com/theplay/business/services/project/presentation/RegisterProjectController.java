package com.theplay.business.services.project.presentation;

import com.theplay.business.services.project.application.RegisterProjectService;
import com.theplay.business.services.project.application.resource.RegisterProjectResource;
import com.theplay.business.services.project.presentation.request.RegisterProjectRequest;
import com.theplay.core.presentation.response.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/projects")
@RequiredArgsConstructor
public class RegisterProjectController {

    private final RegisterProjectService registerProjectService;
    private final RegisterProjectDtoMapper registerProjectDtoMapper;

    @PostMapping
    public ResponseEntity<Response<RegisterProjectResource>> register(
            @Valid @RequestBody RegisterProjectRequest request) {
        return Response.created(registerProjectService.register(registerProjectDtoMapper.mapFrom(request)));
    }
}
