package com.theplay.business.services.workspace.presentation;

import static com.theplay.business.services.workspace.presentation.request.RegisterWorkspaceRequestFixture.aRegisterWorkspaceRequest;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.theplay.business.services.workspace.application.RegisterWorkspaceService;
import com.theplay.business.services.workspace.application.dto.RegisterWorkspaceDto;
import com.theplay.business.services.workspace.application.resource.RegisterWorkspaceResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(RegisterWorkspaceController.class)
@Import(RegisterWorkspaceDtoMapper.class)
class RegisterWorkspaceControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockitoBean
    RegisterWorkspaceService registerWorkspaceService;

    @Test
    @DisplayName("업무공간 생성")
    void register() throws Exception {
        when(registerWorkspaceService.register(any(RegisterWorkspaceDto.class)))
                .thenReturn(new RegisterWorkspaceResource(1L));

        mockMvc.perform(post("/api/v1/workspaces")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(aRegisterWorkspaceRequest())))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.id").value(1L));
    }
}
