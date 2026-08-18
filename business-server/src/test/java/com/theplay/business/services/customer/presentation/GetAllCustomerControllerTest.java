package com.theplay.business.services.customer.presentation;

import static com.theplay.business.services.customer.fixture.CustomerFixture.aGetCustomerResource;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.theplay.business.services.customer.application.GetAllCustomerService;
import com.theplay.business.services.customer.application.dto.GetAllCustomerDto;
import com.theplay.core.presentation.response.PageResource;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(GetAllCustomerController.class)
@Import(GetAllCustomerDtoMapper.class)
class GetAllCustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    GetAllCustomerService getAllCustomerService;

    @Test
    @DisplayName("고객 목록 조회")
    void getAll() throws Exception {
        when(getAllCustomerService.getAll(any(GetAllCustomerDto.class)))
                .thenReturn(new PageResource<>(List.of(aGetCustomerResource()), 0, 20, 1, 1));

        mockMvc.perform(get("/api/v1/customers")
                        .param("name", "광주")
                        .param("page", "0")
                        .param("size", "20"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.contents.length()").value(1))
                .andExpect(jsonPath("$.data.totalElements").value(1));
    }
}
