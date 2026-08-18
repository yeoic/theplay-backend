package com.theplay.business.services.provider.presentation;

import com.theplay.business.services.provider.application.RegisterProviderService;
import com.theplay.business.services.provider.application.resource.RegisterProviderResource;
import com.theplay.business.services.provider.presentation.request.RegisterProviderRequest;
import com.theplay.core.presentation.response.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/providers")
@RequiredArgsConstructor
public class RegisterProviderController {

    private final RegisterProviderService registerProviderService;
    private final RegisterProviderDtoMapper registerProviderDtoMapper;

    @PostMapping
    public ResponseEntity<Response<RegisterProviderResource>> register(
            @Valid @RequestBody RegisterProviderRequest request) {
        return Response.created(registerProviderService.register(registerProviderDtoMapper.mapFrom(request)));
    }
}
