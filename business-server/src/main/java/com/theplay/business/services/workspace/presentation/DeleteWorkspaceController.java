package com.theplay.business.services.workspace.presentation;

import com.theplay.business.services.workspace.application.DeleteWorkspaceService;
import com.theplay.core.presentation.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/workspaces")
@RequiredArgsConstructor
public class DeleteWorkspaceController {

    private final DeleteWorkspaceService deleteWorkspaceService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Void>> delete(@PathVariable long id) {
        deleteWorkspaceService.delete(id);
        return Response.ok(null);
    }
}
