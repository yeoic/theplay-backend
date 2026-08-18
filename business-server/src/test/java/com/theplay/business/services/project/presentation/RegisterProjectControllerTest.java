package com.theplay.business.services.project.presentation;

import static com.theplay.business.services.project.presentation.request.RegisterProjectRequestFixture.aRegisterProjectRequest;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.theplay.business.services.project.application.RegisterProjectService;
import com.theplay.business.services.project.application.dto.RegisterProjectDto;
import com.theplay.business.services.project.application.resource.RegisterProjectResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(RegisterProjectController.class)
@Import(RegisterProjectDtoMapper.class)
class RegisterProjectControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockitoBean
    RegisterProjectService registerProjectService;

    @Test
    @DisplayName("프로젝트 생성")
    void register() throws Exception {
        when(registerProjectService.register(any(RegisterProjectDto.class)))
                .thenReturn(new RegisterProjectResource(1L));

        mockMvc.perform(post("/api/v1/projects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(aRegisterProjectRequest())))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.id").value(1L));
    }
}
