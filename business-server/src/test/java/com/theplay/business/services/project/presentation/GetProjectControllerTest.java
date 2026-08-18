package com.theplay.business.services.project.presentation;

import static com.theplay.business.services.project.fixture.ProjectFixture.aGetProjectResource;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.theplay.business.services.project.application.GetProjectService;
import com.theplay.business.services.project.application.exception.ProjectNotFoundException;
import com.theplay.core.presentation.ServerExceptionHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(GetProjectController.class)
@Import(ServerExceptionHandler.class)
class GetProjectControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    GetProjectService getProjectService;

    @Test
    @DisplayName("프로젝트 개별 조회")
    void getOne() throws Exception {
        when(getProjectService.get(1L)).thenReturn(aGetProjectResource());

        mockMvc.perform(get("/api/v1/projects/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.id").value(1L))
                .andExpect(jsonPath("$.data.name").value("겨울 축제 초청 공연"))
                .andExpect(jsonPath("$.data.status").value("REQUESTED"));
    }

    @Test
    @DisplayName("없는 프로젝트 조회 시 404")
    void getUnknown() throws Exception {
        when(getProjectService.get(999L)).thenThrow(new ProjectNotFoundException(999L));

        mockMvc.perform(get("/api/v1/projects/{id}", 999L))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.errors[0].field").value("projectId"));
    }
}
