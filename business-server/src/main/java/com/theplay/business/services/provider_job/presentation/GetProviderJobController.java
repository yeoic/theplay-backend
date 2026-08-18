package com.theplay.business.services.provider_job.presentation;

import com.theplay.business.services.provider_job.application.GetProviderJobService;
import com.theplay.business.services.provider_job.application.resource.GetProviderJobResource;
import com.theplay.core.presentation.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/provider-jobs")
@RequiredArgsConstructor
public class GetProviderJobController {

    private final GetProviderJobService getProviderJobService;

    @GetMapping("/{id}")
    public ResponseEntity<Response<GetProviderJobResource>> get(@PathVariable long id) {
        return Response.ok(getProviderJobService.get(id));
    }
}
