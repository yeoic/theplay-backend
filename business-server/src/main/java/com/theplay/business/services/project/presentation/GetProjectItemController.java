package com.theplay.business.services.project.presentation;

import com.theplay.business.services.project.application.GetProjectItemService;
import com.theplay.business.services.project.application.resource.GetProjectItemResource;
import com.theplay.core.presentation.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/project-items")
@RequiredArgsConstructor
public class GetProjectItemController {

    private final GetProjectItemService getProjectItemService;

    @GetMapping("/{id}")
    public ResponseEntity<Response<GetProjectItemResource>> get(@PathVariable long id) {
        return Response.ok(getProjectItemService.get(id));
    }
}
