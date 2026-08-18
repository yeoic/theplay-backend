package com.theplay.business.services.customer.presentation;

import com.theplay.business.services.customer.application.GetAllCustomerService;
import com.theplay.business.services.customer.application.resource.GetCustomerResource;
import com.theplay.business.services.customer.presentation.request.GetAllCustomerRequest;
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
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class GetAllCustomerController {

    private final GetAllCustomerService getAllCustomerService;
    private final GetAllCustomerDtoMapper getAllCustomerDtoMapper;

    @GetMapping
    public ResponseEntity<Response<PageResource<GetCustomerResource>>> getAll(
            @ModelAttribute GetAllCustomerRequest request,
            @PageableDefault(size = 20) Pageable pageable) {
        return Response.ok(getAllCustomerService.getAll(getAllCustomerDtoMapper.mapFrom(request, pageable)));
    }
}
