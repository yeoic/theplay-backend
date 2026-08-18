package com.theplay.business.services.customer.presentation;

import com.theplay.business.services.customer.application.RegisterCustomerService;
import com.theplay.business.services.customer.application.resource.RegisterCustomerResource;
import com.theplay.business.services.customer.presentation.request.RegisterCustomerRequest;
import com.theplay.core.presentation.response.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class RegisterCustomerController {

    private final RegisterCustomerService registerCustomerService;
    private final RegisterCustomerDtoMapper registerCustomerDtoMapper;

    @PostMapping
    public ResponseEntity<Response<RegisterCustomerResource>> register(
            @Valid @RequestBody RegisterCustomerRequest request) {
        return Response.created(registerCustomerService.register(registerCustomerDtoMapper.mapFrom(request)));
    }
}
