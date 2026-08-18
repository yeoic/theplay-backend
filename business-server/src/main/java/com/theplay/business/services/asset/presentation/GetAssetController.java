package com.theplay.business.services.asset.presentation;

import com.theplay.business.services.asset.application.GetAssetService;
import com.theplay.business.services.asset.application.resource.GetAssetResource;
import com.theplay.core.presentation.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/assets")
@RequiredArgsConstructor
public class GetAssetController {

    private final GetAssetService getAssetService;

    @GetMapping("/{id}")
    public ResponseEntity<Response<GetAssetResource>> get(@PathVariable long id) {
        return Response.ok(getAssetService.get(id));
    }
}
