package com.theplay.business.services.provider.presentation;

import static com.theplay.business.services.provider.fixture.ProviderFixture.aGetProviderResource;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.theplay.business.services.provider.application.GetProviderService;
import com.theplay.business.services.provider.application.exception.ProviderNotFoundException;
import com.theplay.core.presentation.ServerExceptionHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(GetProviderController.class)
@Import(ServerExceptionHandler.class)
class GetProviderControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    GetProviderService getProviderService;

    @Test
    @DisplayName("공급사 개별 조회")
    void getOne() throws Exception {
        when(getProviderService.get(1L)).thenReturn(aGetProviderResource());

        mockMvc.perform(get("/api/v1/providers/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.id").value(1L))
                .andExpect(jsonPath("$.data.name").value("청춘마이크 밴드"))
                .andExpect(jsonPath("$.data.category").value("PERFORMANCE"));
    }

    @Test
    @DisplayName("없는 공급사 조회 시 404")
    void getUnknown() throws Exception {
        when(getProviderService.get(999L)).thenThrow(new ProviderNotFoundException(999L));

        mockMvc.perform(get("/api/v1/providers/{id}", 999L))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.errors[0].field").value("providerId"));
    }
}
