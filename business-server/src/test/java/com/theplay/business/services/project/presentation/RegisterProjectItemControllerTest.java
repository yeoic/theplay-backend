package com.theplay.business.services.project.presentation;

import static com.theplay.business.services.project.presentation.request.RegisterProjectItemRequestFixture.aRegisterProjectItemRequest;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.theplay.business.services.project.application.RegisterProjectItemService;
import com.theplay.business.services.project.application.dto.RegisterProjectItemDto;
import com.theplay.business.services.project.application.resource.RegisterProjectItemResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(RegisterProjectItemController.class)
@Import(RegisterProjectItemDtoMapper.class)
class RegisterProjectItemControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockitoBean
    RegisterProjectItemService registerProjectItemService;

    @Test
    @DisplayName("프로젝트 견적 항목 생성")
    void register() throws Exception {
        when(registerProjectItemService.register(any(RegisterProjectItemDto.class)))
                .thenReturn(new RegisterProjectItemResource(1L));

        mockMvc.perform(post("/api/v1/project-items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(aRegisterProjectItemRequest())))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.id").value(1L));
    }
}
