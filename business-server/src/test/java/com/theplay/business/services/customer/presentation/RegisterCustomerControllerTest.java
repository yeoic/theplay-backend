package com.theplay.business.services.customer.presentation;

import static com.theplay.business.services.customer.presentation.request.RegisterCustomerRequestFixture.aRegisterCustomerRequest;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.theplay.business.services.customer.application.RegisterCustomerService;
import com.theplay.business.services.customer.application.dto.RegisterCustomerDto;
import com.theplay.business.services.customer.application.resource.RegisterCustomerResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(RegisterCustomerController.class)
@Import(RegisterCustomerDtoMapper.class)
class RegisterCustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockitoBean
    RegisterCustomerService registerCustomerService;

    @Test
    @DisplayName("고객 생성")
    void register() throws Exception {
        when(registerCustomerService.register(any(RegisterCustomerDto.class)))
                .thenReturn(new RegisterCustomerResource(1L));

        mockMvc.perform(post("/api/v1/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(aRegisterCustomerRequest())))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.id").value(1L));
    }
}
