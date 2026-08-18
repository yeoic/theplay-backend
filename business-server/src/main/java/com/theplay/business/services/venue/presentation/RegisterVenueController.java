package com.theplay.business.services.venue.presentation;

import com.theplay.business.services.venue.application.RegisterVenueService;
import com.theplay.business.services.venue.application.resource.RegisterVenueResource;
import com.theplay.business.services.venue.presentation.request.RegisterVenueRequest;
import com.theplay.core.presentation.response.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/venues")
@RequiredArgsConstructor
public class RegisterVenueController {

    private final RegisterVenueService registerVenueService;
    private final RegisterVenueDtoMapper registerVenueDtoMapper;

    @PostMapping
    public ResponseEntity<Response<RegisterVenueResource>> register(
            @Valid @RequestBody RegisterVenueRequest request) {
        return Response.created(registerVenueService.register(registerVenueDtoMapper.mapFrom(request)));
    }
}
