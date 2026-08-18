package com.theplay.business.services.customer.application.resource;

import com.theplay.business.services.customer.domain.Customer;
import java.time.LocalDateTime;

public record GetCustomerResource(long id, String name, String managerName, String phoneNumber, String email,
                                  LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {

    public static GetCustomerResource from(Customer customer) {
        return new GetCustomerResource(
                customer.getId(),
                customer.getName(),
                customer.getManagerName(),
                customer.getPhoneNumber(),
                customer.getEmail(),
                customer.getCreatedAt(),
                customer.getUpdatedAt(),
                customer.getDeletedAt());
    }
}
