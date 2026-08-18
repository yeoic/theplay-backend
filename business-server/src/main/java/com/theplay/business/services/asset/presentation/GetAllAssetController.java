package com.theplay.business.services.asset.presentation;

import com.theplay.business.services.asset.application.GetAllAssetService;
import com.theplay.business.services.asset.application.resource.GetAssetResource;
import com.theplay.business.services.asset.presentation.request.GetAllAssetRequest;
import com.theplay.core.presentation.response.PageResource;
import com.theplay.core.presentation.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/assets")
@RequiredArgsConstructor
public class GetAllAssetController {

    private final GetAllAssetService getAllAssetService;
    private final GetAllAssetDtoMapper getAllAssetDtoMapper;

    @GetMapping
    public ResponseEntity<Response<PageResource<GetAssetResource>>> getAll(
            @ModelAttribute GetAllAssetRequest request,
            @PageableDefault(size = 20) Pageable pageable) {
        return Response.ok(getAllAssetService.getAll(getAllAssetDtoMapper.mapFrom(request, pageable)));
    }
}
