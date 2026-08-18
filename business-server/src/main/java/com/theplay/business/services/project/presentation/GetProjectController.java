package com.theplay.business.services.project.presentation;

import com.theplay.business.services.project.application.GetProjectService;
import com.theplay.business.services.project.application.resource.GetProjectResource;
import com.theplay.core.presentation.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/projects")
@RequiredArgsConstructor
public class GetProjectController {

    private final GetProjectService getProjectService;

    @GetMapping("/{id}")
    public ResponseEntity<Response<GetProjectResource>> get(@PathVariable long id) {
        return Response.ok(getProjectService.get(id));
    }
}
