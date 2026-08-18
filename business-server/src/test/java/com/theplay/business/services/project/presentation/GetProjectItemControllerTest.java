package com.theplay.business.services.project.presentation;

import static com.theplay.business.services.project.fixture.ProjectItemFixture.aGetProjectItemResource;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.theplay.business.services.project.application.GetProjectItemService;
import com.theplay.business.services.project.application.exception.ProjectItemNotFoundException;
import com.theplay.core.presentation.ServerExceptionHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(GetProjectItemController.class)
@Import(ServerExceptionHandler.class)
class GetProjectItemControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    GetProjectItemService getProjectItemService;

    @Test
    @DisplayName("프로젝트 견적 항목 개별 조회")
    void getOne() throws Exception {
        when(getProjectItemService.get(1L)).thenReturn(aGetProjectItemResource());

        mockMvc.perform(get("/api/v1/project-items/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.id").value(1L))
                .andExpect(jsonPath("$.data.providerJobId").value(1))
                .andExpect(jsonPath("$.data.jobName").value("넌버벌 퍼포먼스 '비트'"))
                .andExpect(jsonPath("$.data.providerName").value("청춘마이크 밴드"))
                .andExpect(jsonPath("$.data.headcount").value(4))
                .andExpect(jsonPath("$.data.status").value("WAITING"))
                .andExpect(jsonPath("$.data.executionStatus").value("PROPOSED"))
                .andExpect(jsonPath("$.data.paymentStatus").value("PAYMENT_PENDING"))
                .andExpect(jsonPath("$.data.settlementStatus").value("SETTLEMENT_PENDING"));
    }

    @Test
    @DisplayName("없는 프로젝트 견적 항목 조회 시 404")
    void getUnknown() throws Exception {
        when(getProjectItemService.get(999L)).thenThrow(new ProjectItemNotFoundException(999L));

        mockMvc.perform(get("/api/v1/project-items/{id}", 999L))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.errors[0].field").value("projectItemId"));
    }
}
