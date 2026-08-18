package com.theplay.business.services.project.presentation;

import com.theplay.business.services.project.application.RegisterProjectItemService;
import com.theplay.business.services.project.application.resource.RegisterProjectItemResource;
import com.theplay.business.services.project.presentation.request.RegisterProjectItemRequest;
import com.theplay.core.presentation.response.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/project-items")
@RequiredArgsConstructor
public class RegisterProjectItemController {

    private final RegisterProjectItemService registerProjectItemService;
    private final RegisterProjectItemDtoMapper registerProjectItemDtoMapper;

    @PostMapping
    public ResponseEntity<Response<RegisterProjectItemResource>> register(
            @Valid @RequestBody RegisterProjectItemRequest request) {
        return Response.created(registerProjectItemService.register(registerProjectItemDtoMapper.mapFrom(request)));
    }
}
