package com.theplay.business.services.provider.presentation;

import static com.theplay.business.services.provider.presentation.request.RegisterProviderRequestFixture.aRegisterProviderRequest;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.theplay.business.services.provider.application.RegisterProviderService;
import com.theplay.business.services.provider.application.dto.RegisterProviderDto;
import com.theplay.business.services.provider.application.resource.RegisterProviderResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(RegisterProviderController.class)
@Import(RegisterProviderDtoMapper.class)
class RegisterProviderControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockitoBean
    RegisterProviderService registerProviderService;

    @Test
    @DisplayName("공급사 생성")
    void register() throws Exception {
        when(registerProviderService.register(any(RegisterProviderDto.class)))
                .thenReturn(new RegisterProviderResource(1L));

        mockMvc.perform(post("/api/v1/providers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(aRegisterProviderRequest())))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.id").value(1L));
    }
}
