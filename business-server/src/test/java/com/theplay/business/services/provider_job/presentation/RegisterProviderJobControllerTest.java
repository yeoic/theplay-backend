package com.theplay.business.services.provider_job.presentation;

import static com.theplay.business.services.provider_job.presentation.request.RegisterProviderJobRequestFixture.aRegisterProviderJobRequest;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.theplay.business.services.provider_job.application.RegisterProviderJobService;
import com.theplay.business.services.provider_job.application.dto.RegisterProviderJobDto;
import com.theplay.business.services.provider_job.application.resource.RegisterProviderJobResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(RegisterProviderJobController.class)
@Import(RegisterProviderJobDtoMapper.class)
class RegisterProviderJobControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockitoBean
    RegisterProviderJobService registerProviderJobService;

    @Test
    @DisplayName("제공 서비스 생성")
    void register() throws Exception {
        when(registerProviderJobService.register(any(RegisterProviderJobDto.class)))
                .thenReturn(new RegisterProviderJobResource(1L));

        mockMvc.perform(post("/api/v1/provider-jobs")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(aRegisterProviderJobRequest())))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.id").value(1L));
    }
}
