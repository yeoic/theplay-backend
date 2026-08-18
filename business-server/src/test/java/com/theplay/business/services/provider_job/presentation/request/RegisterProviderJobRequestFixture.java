package com.theplay.business.services.provider_job.presentation.request;

public class RegisterProviderJobRequestFixture {

    public static RegisterProviderJobRequest aRegisterProviderJobRequest() {
        return new RegisterProviderJobRequest(
                "넌버벌 퍼포먼스 '비트'", 1L, 3_000_000L, 80, 4, "타악 리듬 중심의 넌버벌 공연");
    }
}
