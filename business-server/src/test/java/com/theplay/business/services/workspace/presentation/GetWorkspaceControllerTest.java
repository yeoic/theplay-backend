package com.theplay.business.services.workspace.presentation;

import static com.theplay.business.services.workspace.fixture.WorkspaceFixture.aGetWorkspaceResource;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.theplay.business.services.workspace.application.GetWorkspaceService;
import com.theplay.business.services.workspace.application.exception.WorkspaceNotFoundException;
import com.theplay.core.presentation.ServerExceptionHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(GetWorkspaceController.class)
@Import(ServerExceptionHandler.class)
class GetWorkspaceControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    GetWorkspaceService getWorkspaceService;

    @Test
    @DisplayName("업무공간 개별 조회")
    void getOne() throws Exception {
        when(getWorkspaceService.get(1L)).thenReturn(aGetWorkspaceResource());

        mockMvc.perform(get("/api/v1/workspaces/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.id").value(1L))
                .andExpect(jsonPath("$.data.name").value("양벌동 장비창고"))
                .andExpect(jsonPath("$.data.type").value("WAREHOUSE"));
    }

    @Test
    @DisplayName("없는 업무공간 조회 시 404")
    void getUnknown() throws Exception {
        when(getWorkspaceService.get(999L)).thenThrow(new WorkspaceNotFoundException(999L));

        mockMvc.perform(get("/api/v1/workspaces/{id}", 999L))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.errors[0].field").value("workspaceId"));
    }
}
