package com.theplay.business.services.customer.presentation.request;

import com.theplay.business.services.customer.presentation.request.RegisterCustomerRequest;

public class RegisterCustomerRequestFixture {

    public static RegisterCustomerRequest aRegisterCustomerRequest() {
        return new RegisterCustomerRequest(
                "광주시청 문화과", "김담당", "031-000-0000", "culture@example.org");
    }
}
