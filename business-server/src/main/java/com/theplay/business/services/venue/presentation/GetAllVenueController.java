package com.theplay.business.services.venue.presentation;

import com.theplay.business.services.venue.application.GetAllVenueService;
import com.theplay.business.services.venue.application.resource.GetVenueResource;
import com.theplay.business.services.venue.presentation.request.GetAllVenueRequest;
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
@RequestMapping("/api/v1/venues")
@RequiredArgsConstructor
public class GetAllVenueController {

    private final GetAllVenueService getAllVenueService;
    private final GetAllVenueDtoMapper getAllVenueDtoMapper;

    @GetMapping
    public ResponseEntity<Response<PageResource<GetVenueResource>>> getAll(
            @ModelAttribute GetAllVenueRequest request,
            @PageableDefault(size = 20) Pageable pageable) {
        return Response.ok(getAllVenueService.getAll(getAllVenueDtoMapper.mapFrom(request, pageable)));
    }
}
