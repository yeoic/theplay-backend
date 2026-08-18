package com.theplay.business.services.customer.application.dto;

import org.springframework.data.domain.Pageable;

public record GetAllCustomerDto(String name, String phoneNumber, Pageable pageable) {
}
