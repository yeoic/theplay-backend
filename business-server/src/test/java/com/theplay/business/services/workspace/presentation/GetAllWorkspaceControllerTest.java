package com.theplay.business.services.workspace.presentation;

import static com.theplay.business.services.workspace.fixture.WorkspaceFixture.aGetWorkspaceResource;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.theplay.business.services.workspace.application.GetAllWorkspaceService;
import com.theplay.business.services.workspace.application.dto.GetAllWorkspaceDto;
import com.theplay.core.presentation.response.PageResource;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(GetAllWorkspaceController.class)
@Import(GetAllWorkspaceDtoMapper.class)
class GetAllWorkspaceControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    GetAllWorkspaceService getAllWorkspaceService;

    @Test
    @DisplayName("업무공간 목록 조회")
    void getAll() throws Exception {
        when(getAllWorkspaceService.getAll(any(GetAllWorkspaceDto.class)))
                .thenReturn(new PageResource<>(List.of(aGetWorkspaceResource()), 0, 20, 1, 1));

        mockMvc.perform(get("/api/v1/workspaces")
                        .param("name", "양벌동")
                        .param("type", "WAREHOUSE")
                        .param("page", "0")
                        .param("size", "20"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.contents.length()").value(1))
                .andExpect(jsonPath("$.data.totalElements").value(1));
    }
}
