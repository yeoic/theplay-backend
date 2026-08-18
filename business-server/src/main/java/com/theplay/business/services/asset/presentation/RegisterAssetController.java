package com.theplay.business.services.asset.presentation;

import com.theplay.business.services.asset.application.RegisterAssetService;
import com.theplay.business.services.asset.application.resource.RegisterAssetResource;
import com.theplay.business.services.asset.presentation.request.RegisterAssetRequest;
import com.theplay.core.presentation.response.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/assets")
@RequiredArgsConstructor
public class RegisterAssetController {

    private final RegisterAssetService registerAssetService;
    private final RegisterAssetDtoMapper registerAssetDtoMapper;

    @PostMapping
    public ResponseEntity<Response<RegisterAssetResource>> register(
            @Valid @RequestBody RegisterAssetRequest request) {
        return Response.created(registerAssetService.register(registerAssetDtoMapper.mapFrom(request)));
    }
}
