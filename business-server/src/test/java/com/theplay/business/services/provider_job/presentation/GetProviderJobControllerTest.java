package com.theplay.business.services.provider_job.presentation;

import static com.theplay.business.services.provider_job.fixture.ProviderJobFixture.aGetProviderJobResource;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.theplay.business.services.provider_job.application.GetProviderJobService;
import com.theplay.business.services.provider_job.application.exception.ProviderJobNotFoundException;
import com.theplay.core.presentation.ServerExceptionHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(GetProviderJobController.class)
@Import(ServerExceptionHandler.class)
class GetProviderJobControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    GetProviderJobService getProviderJobService;

    @Test
    @DisplayName("제공 서비스 개별 조회")
    void getOne() throws Exception {
        when(getProviderJobService.get(1L)).thenReturn(aGetProviderJobResource());

        mockMvc.perform(get("/api/v1/provider-jobs/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.id").value(1L))
                .andExpect(jsonPath("$.data.name").value("넌버벌 퍼포먼스 '비트'"))
                .andExpect(jsonPath("$.data.durationMinutes").value(80));
    }

    @Test
    @DisplayName("없는 제공 서비스 조회 시 404")
    void getUnknown() throws Exception {
        when(getProviderJobService.get(999L)).thenThrow(new ProviderJobNotFoundException(999L));

        mockMvc.perform(get("/api/v1/provider-jobs/{id}", 999L))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.errors[0].field").value("providerJobId"));
    }
}
