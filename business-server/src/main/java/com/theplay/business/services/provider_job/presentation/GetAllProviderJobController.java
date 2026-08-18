package com.theplay.business.services.provider_job.presentation;

import com.theplay.business.services.provider_job.application.GetAllProviderJobService;
import com.theplay.business.services.provider_job.application.resource.GetProviderJobResource;
import com.theplay.business.services.provider_job.presentation.request.GetAllProviderJobRequest;
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
@RequestMapping("/api/v1/provider-jobs")
@RequiredArgsConstructor
public class GetAllProviderJobController {

    private final GetAllProviderJobService getAllProviderJobService;
    private final GetAllProviderJobDtoMapper getAllProviderJobDtoMapper;

    @GetMapping
    public ResponseEntity<Response<PageResource<GetProviderJobResource>>> getAll(
            @ModelAttribute GetAllProviderJobRequest request,
            @PageableDefault(size = 20) Pageable pageable) {
        return Response.ok(getAllProviderJobService.getAll(getAllProviderJobDtoMapper.mapFrom(request, pageable)));
    }
}
