package com.theplay.business.services.asset.presentation;

import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.theplay.business.services.asset.application.DeleteAssetService;
import com.theplay.business.services.asset.application.exception.AssetNotFoundException;
import com.theplay.core.presentation.ServerExceptionHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(DeleteAssetController.class)
@Import(ServerExceptionHandler.class)
class DeleteAssetControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    DeleteAssetService deleteAssetService;

    @Test
    @DisplayName("자산 삭제")
    void deleteOne() throws Exception {
        mockMvc.perform(delete("/api/v1/assets/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true));
    }

    @Test
    @DisplayName("없는 자산 삭제 시 404")
    void deleteUnknown() throws Exception {
        doThrow(new AssetNotFoundException(999L)).when(deleteAssetService).delete(999L);

        mockMvc.perform(delete("/api/v1/assets/{id}", 999L))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.success").value(false));
    }
}
