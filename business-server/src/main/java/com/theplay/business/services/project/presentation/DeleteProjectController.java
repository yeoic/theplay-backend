package com.theplay.business.services.project.presentation;

import com.theplay.business.services.project.application.DeleteProjectService;
import com.theplay.core.presentation.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/projects")
@RequiredArgsConstructor
public class DeleteProjectController {

    private final DeleteProjectService deleteProjectService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Void>> delete(@PathVariable long id) {
        deleteProjectService.delete(id);
        return Response.ok(null);
    }
}
