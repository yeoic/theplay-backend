package com.theplay.business.services.customer.presentation;

import com.theplay.business.services.customer.application.DeleteCustomerService;
import com.theplay.core.presentation.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class DeleteCustomerController {

    private final DeleteCustomerService deleteCustomerService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Void>> delete(@PathVariable long id) {
        deleteCustomerService.delete(id);
        return Response.ok(null);
    }
}
