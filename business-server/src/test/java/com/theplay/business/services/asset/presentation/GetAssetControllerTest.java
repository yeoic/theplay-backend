package com.theplay.business.services.asset.presentation;

import static com.theplay.business.services.asset.fixture.AssetFixture.aGetAssetResource;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.theplay.business.services.asset.application.GetAssetService;
import com.theplay.business.services.asset.application.exception.AssetNotFoundException;
import com.theplay.core.presentation.ServerExceptionHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(GetAssetController.class)
@Import(ServerExceptionHandler.class)
class GetAssetControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    GetAssetService getAssetService;

    @Test
    @DisplayName("자산 개별 조회")
    void getOne() throws Exception {
        when(getAssetService.get(1L)).thenReturn(aGetAssetResource());

        mockMvc.perform(get("/api/v1/assets/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.id").value(1L))
                .andExpect(jsonPath("$.data.name").value("무빙라이트 세트"))
                .andExpect(jsonPath("$.data.status").value("AVAILABLE"));
    }

    @Test
    @DisplayName("없는 자산 조회 시 404")
    void getUnknown() throws Exception {
        when(getAssetService.get(999L)).thenThrow(new AssetNotFoundException(999L));

        mockMvc.perform(get("/api/v1/assets/{id}", 999L))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.errors[0].field").value("assetId"));
    }
}
