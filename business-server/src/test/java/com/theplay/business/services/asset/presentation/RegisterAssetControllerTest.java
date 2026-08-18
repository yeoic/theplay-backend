package com.theplay.business.services.asset.presentation;

import static com.theplay.business.services.asset.presentation.request.RegisterAssetRequestFixture.aRegisterAssetRequest;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.theplay.business.services.asset.application.RegisterAssetService;
import com.theplay.business.services.asset.application.dto.RegisterAssetDto;
import com.theplay.business.services.asset.application.resource.RegisterAssetResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(RegisterAssetController.class)
@Import(RegisterAssetDtoMapper.class)
class RegisterAssetControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockitoBean
    RegisterAssetService registerAssetService;

    @Test
    @DisplayName("자산 생성")
    void register() throws Exception {
        when(registerAssetService.register(any(RegisterAssetDto.class)))
                .thenReturn(new RegisterAssetResource(1L));

        mockMvc.perform(post("/api/v1/assets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(aRegisterAssetRequest())))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.id").value(1L));
    }
}
