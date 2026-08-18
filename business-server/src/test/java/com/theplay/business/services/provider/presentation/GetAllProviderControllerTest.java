package com.theplay.business.services.provider.presentation;

import static com.theplay.business.services.provider.fixture.ProviderFixture.aGetProviderResource;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.theplay.business.services.provider.application.GetAllProviderService;
import com.theplay.business.services.provider.application.dto.GetAllProviderDto;
import com.theplay.core.presentation.response.PageResource;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(GetAllProviderController.class)
@Import(GetAllProviderDtoMapper.class)
class GetAllProviderControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    GetAllProviderService getAllProviderService;

    @Test
    @DisplayName("공급사 목록 조회")
    void getAll() throws Exception {
        when(getAllProviderService.getAll(any(GetAllProviderDto.class)))
                .thenReturn(new PageResource<>(List.of(aGetProviderResource()), 0, 20, 1, 1));

        mockMvc.perform(get("/api/v1/providers")
                        .param("name", "청춘마이크")
                        .param("category", "PERFORMANCE")
                        .param("page", "0")
                        .param("size", "20"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.contents.length()").value(1))
                .andExpect(jsonPath("$.data.totalElements").value(1));
    }
}
