package com.theplay.business.services.project.presentation;

import static com.theplay.business.services.project.fixture.ProjectItemFixture.aGetProjectItemResource;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.theplay.business.services.project.application.GetAllProjectItemService;
import com.theplay.business.services.project.application.dto.GetAllProjectItemDto;
import com.theplay.core.presentation.response.PageResource;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(GetAllProjectItemController.class)
@Import(GetAllProjectItemDtoMapper.class)
class GetAllProjectItemControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    GetAllProjectItemService getAllProjectItemService;

    @Test
    @DisplayName("프로젝트 견적 항목 목록 조회")
    void getAll() throws Exception {
        when(getAllProjectItemService.getAll(any(GetAllProjectItemDto.class)))
                .thenReturn(new PageResource<>(List.of(aGetProjectItemResource()), 0, 20, 1, 1));

        mockMvc.perform(get("/api/v1/project-items")
                        .param("projectId", "1")
                        .param("status", "WAITING")
                        .param("page", "0")
                        .param("size", "20"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.contents.length()").value(1))
                .andExpect(jsonPath("$.data.totalElements").value(1));
    }
}
