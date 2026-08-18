package com.theplay.business.services.venue.presentation;

import com.theplay.business.services.venue.application.GetVenueService;
import com.theplay.business.services.venue.application.resource.GetVenueResource;
import com.theplay.core.presentation.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/venues")
@RequiredArgsConstructor
public class GetVenueController {

    private final GetVenueService getVenueService;

    @GetMapping("/{id}")
    public ResponseEntity<Response<GetVenueResource>> get(@PathVariable long id) {
        return Response.ok(getVenueService.get(id));
    }
}
