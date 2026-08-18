package com.theplay.business.services.provider_job.fixture;

import com.theplay.business.services.provider_job.application.resource.GetProviderJobResource;
import com.theplay.business.services.provider_job.domain.ProviderJob;

public class ProviderJobFixture {

    public static ProviderJob.ProviderJobBuilder aProviderJob() {
        return ProviderJob.builder()
                .id(1L)
                .name("넌버벌 퍼포먼스 '비트'")
                .providerId(1L)
                .price(3_000_000L)
                .durationMinutes(80)
                .headcount(4)
                .description("타악 리듬 중심의 넌버벌 공연");
    }

    public static GetProviderJobResource aGetProviderJobResource() {
        return GetProviderJobResource.from(aProviderJob().build());
    }
}
