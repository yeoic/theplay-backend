package com.theplay.business.services.provider_job.presentation;

import com.theplay.business.services.provider_job.application.RegisterProviderJobService;
import com.theplay.business.services.provider_job.application.resource.RegisterProviderJobResource;
import com.theplay.business.services.provider_job.presentation.request.RegisterProviderJobRequest;
import com.theplay.core.presentation.response.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/provider-jobs")
@RequiredArgsConstructor
public class RegisterProviderJobController {

    private final RegisterProviderJobService registerProviderJobService;
    private final RegisterProviderJobDtoMapper registerProviderJobDtoMapper;

    @PostMapping
    public ResponseEntity<Response<RegisterProviderJobResource>> register(
            @Valid @RequestBody RegisterProviderJobRequest request) {
        return Response.created(registerProviderJobService.register(registerProviderJobDtoMapper.mapFrom(request)));
    }
}
