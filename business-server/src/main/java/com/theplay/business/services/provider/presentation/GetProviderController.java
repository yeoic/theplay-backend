package com.theplay.business.services.provider.presentation;

import com.theplay.business.services.provider.application.GetProviderService;
import com.theplay.business.services.provider.application.resource.GetProviderResource;
import com.theplay.core.presentation.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/providers")
@RequiredArgsConstructor
public class GetProviderController {

    private final GetProviderService getProviderService;

    @GetMapping("/{id}")
    public ResponseEntity<Response<GetProviderResource>> get(@PathVariable long id) {
        return Response.ok(getProviderService.get(id));
    }
}
