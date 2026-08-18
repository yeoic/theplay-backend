package com.theplay.business.services.project.presentation;

import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.theplay.business.services.project.application.DeleteProjectService;
import com.theplay.business.services.project.application.exception.ProjectNotFoundException;
import com.theplay.core.presentation.ServerExceptionHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(DeleteProjectController.class)
@Import(ServerExceptionHandler.class)
class DeleteProjectControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    DeleteProjectService deleteProjectService;

    @Test
    @DisplayName("프로젝트 삭제")
    void deleteOne() throws Exception {
        mockMvc.perform(delete("/api/v1/projects/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true));
    }

    @Test
    @DisplayName("없는 프로젝트 삭제 시 404")
    void deleteUnknown() throws Exception {
        doThrow(new ProjectNotFoundException(999L)).when(deleteProjectService).delete(999L);

        mockMvc.perform(delete("/api/v1/projects/{id}", 999L))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.success").value(false));
    }
}
