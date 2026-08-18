package com.theplay.business.services.customer.presentation;

import static com.theplay.business.services.customer.fixture.CustomerFixture.aGetCustomerResource;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.theplay.business.services.customer.application.GetCustomerService;
import com.theplay.business.services.customer.application.exception.CustomerNotFoundException;
import com.theplay.core.presentation.ServerExceptionHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(GetCustomerController.class)
@Import(ServerExceptionHandler.class)
class GetCustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    GetCustomerService getCustomerService;

    @Test
    @DisplayName("고객 개별 조회")
    void getOne() throws Exception {
        when(getCustomerService.get(1L)).thenReturn(aGetCustomerResource());

        mockMvc.perform(get("/api/v1/customers/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.id").value(1L))
                .andExpect(jsonPath("$.data.name").value("광주시청 문화과"))
                .andExpect(jsonPath("$.data.phoneNumber").value("031-000-0000"));
    }

    @Test
    @DisplayName("없는 고객 조회 시 404")
    void getUnknown() throws Exception {
        when(getCustomerService.get(999L)).thenThrow(new CustomerNotFoundException(999L));

        mockMvc.perform(get("/api/v1/customers/{id}", 999L))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.errors[0].field").value("customerId"));
    }
}
