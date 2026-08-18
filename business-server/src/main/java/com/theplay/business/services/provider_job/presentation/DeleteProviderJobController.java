package com.theplay.business.services.provider_job.presentation;

import com.theplay.business.services.provider_job.application.DeleteProviderJobService;
import com.theplay.core.presentation.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/provider-jobs")
@RequiredArgsConstructor
public class DeleteProviderJobController {

    private final DeleteProviderJobService deleteProviderJobService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Void>> delete(@PathVariable long id) {
        deleteProviderJobService.delete(id);
        return Response.ok(null);
    }
}
