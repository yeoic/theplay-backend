package com.theplay.business.services.provider.presentation;

import com.theplay.business.services.provider.application.GetAllProviderService;
import com.theplay.business.services.provider.application.resource.GetProviderResource;
import com.theplay.business.services.provider.presentation.request.GetAllProviderRequest;
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
@RequestMapping("/api/v1/providers")
@RequiredArgsConstructor
public class GetAllProviderController {

    private final GetAllProviderService getAllProviderService;
    private final GetAllProviderDtoMapper getAllProviderDtoMapper;

    @GetMapping
    public ResponseEntity<Response<PageResource<GetProviderResource>>> getAll(
            @ModelAttribute GetAllProviderRequest request,
            @PageableDefault(size = 20) Pageable pageable) {
        return Response.ok(getAllProviderService.getAll(getAllProviderDtoMapper.mapFrom(request, pageable)));
    }
}
