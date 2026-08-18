package com.theplay.business.services.customer.fixture;

import com.theplay.business.services.customer.application.resource.GetCustomerResource;
import com.theplay.business.services.customer.domain.Customer;

public class CustomerFixture {

    public static Customer.CustomerBuilder aCustomer() {
        return Customer.builder()
                .id(1L)
                .name("광주시청 문화과")
                .managerName("김담당")
                .phoneNumber("031-000-0000")
                .email("culture@example.org");
    }

    public static GetCustomerResource aGetCustomerResource() {
        return GetCustomerResource.from(aCustomer().build());
    }
}
