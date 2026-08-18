package com.theplay.business.services.provider.presentation;

import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.theplay.business.services.provider.application.DeleteProviderService;
import com.theplay.business.services.provider.application.exception.ProviderNotFoundException;
import com.theplay.core.presentation.ServerExceptionHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(DeleteProviderController.class)
@Import(ServerExceptionHandler.class)
class DeleteProviderControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    DeleteProviderService deleteProviderService;

    @Test
    @DisplayName("공급사 삭제")
    void deleteOne() throws Exception {
        mockMvc.perform(delete("/api/v1/providers/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true));
    }

    @Test
    @DisplayName("없는 공급사 삭제 시 404")
    void deleteUnknown() throws Exception {
        doThrow(new ProviderNotFoundException(999L)).when(deleteProviderService).delete(999L);

        mockMvc.perform(delete("/api/v1/providers/{id}", 999L))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.success").value(false));
    }
}
