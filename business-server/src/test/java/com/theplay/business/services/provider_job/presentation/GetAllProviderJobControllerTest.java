package com.theplay.business.services.provider_job.presentation;

import static com.theplay.business.services.provider_job.fixture.ProviderJobFixture.aGetProviderJobResource;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.theplay.business.services.provider_job.application.GetAllProviderJobService;
import com.theplay.business.services.provider_job.application.dto.GetAllProviderJobDto;
import com.theplay.core.presentation.response.PageResource;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(GetAllProviderJobController.class)
@Import(GetAllProviderJobDtoMapper.class)
class GetAllProviderJobControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    GetAllProviderJobService getAllProviderJobService;

    @Test
    @DisplayName("제공 서비스 목록 조회")
    void getAll() throws Exception {
        when(getAllProviderJobService.getAll(any(GetAllProviderJobDto.class)))
                .thenReturn(new PageResource<>(List.of(aGetProviderJobResource()), 0, 20, 1, 1));

        mockMvc.perform(get("/api/v1/provider-jobs")
                        .param("providerId", "1")
                        .param("name", "넌버벌")
                        .param("page", "0")
                        .param("size", "20"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.contents.length()").value(1))
                .andExpect(jsonPath("$.data.totalElements").value(1));
    }
}
