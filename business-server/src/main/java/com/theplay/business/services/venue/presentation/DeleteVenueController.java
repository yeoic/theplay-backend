package com.theplay.business.services.venue.presentation;

import com.theplay.business.services.venue.application.DeleteVenueService;
import com.theplay.core.presentation.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/venues")
@RequiredArgsConstructor
public class DeleteVenueController {

    private final DeleteVenueService deleteVenueService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Void>> delete(@PathVariable long id) {
        deleteVenueService.delete(id);
        return Response.ok(null);
    }
}
