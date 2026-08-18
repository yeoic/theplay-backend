package com.theplay.business.services.venue.presentation;

import static com.theplay.business.services.venue.presentation.request.RegisterVenueRequestFixture.aRegisterVenueRequest;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.theplay.business.services.venue.application.RegisterVenueService;
import com.theplay.business.services.venue.application.dto.RegisterVenueDto;
import com.theplay.business.services.venue.application.resource.RegisterVenueResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(RegisterVenueController.class)
@Import(RegisterVenueDtoMapper.class)
class RegisterVenueControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockitoBean
    RegisterVenueService registerVenueService;

    @Test
    @DisplayName("공연장 생성")
    void register() throws Exception {
        when(registerVenueService.register(any(RegisterVenueDto.class)))
                .thenReturn(new RegisterVenueResource(1L));

        mockMvc.perform(post("/api/v1/venues")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(aRegisterVenueRequest())))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.id").value(1L));
    }
}
