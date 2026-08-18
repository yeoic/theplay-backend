package com.theplay.business.services.project.presentation;

import static com.theplay.business.services.project.fixture.ProjectFixture.aGetProjectResource;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.theplay.business.services.project.application.GetAllProjectService;
import com.theplay.business.services.project.application.dto.GetAllProjectDto;
import com.theplay.core.presentation.response.PageResource;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(GetAllProjectController.class)
@Import(GetAllProjectDtoMapper.class)
class GetAllProjectControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    GetAllProjectService getAllProjectService;

    @Test
    @DisplayName("프로젝트 목록 조회")
    void getAll() throws Exception {
        when(getAllProjectService.getAll(any(GetAllProjectDto.class)))
                .thenReturn(new PageResource<>(List.of(aGetProjectResource()), 0, 20, 1, 1));

        mockMvc.perform(get("/api/v1/projects")
                        .param("customerId", "1")
                        .param("status", "REQUESTED")
                        .param("page", "0")
                        .param("size", "20"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.contents.length()").value(1))
                .andExpect(jsonPath("$.data.totalElements").value(1));
    }
}
