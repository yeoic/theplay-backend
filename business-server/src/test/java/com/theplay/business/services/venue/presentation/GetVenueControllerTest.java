package com.theplay.business.services.venue.presentation;

import static com.theplay.business.services.venue.fixture.VenueFixture.aGetVenueResource;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.theplay.business.services.venue.application.GetVenueService;
import com.theplay.business.services.venue.application.exception.VenueNotFoundException;
import com.theplay.core.presentation.ServerExceptionHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(GetVenueController.class)
@Import(ServerExceptionHandler.class)
class GetVenueControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    GetVenueService getVenueService;

    @Test
    @DisplayName("공연장 개별 조회")
    void getOne() throws Exception {
        when(getVenueService.get(1L)).thenReturn(aGetVenueResource());

        mockMvc.perform(get("/api/v1/venues/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.id").value(1L))
                .andExpect(jsonPath("$.data.name").value("남한산성 야외무대"))
                .andExpect(jsonPath("$.data.seatCount").value(500));
    }

    @Test
    @DisplayName("없는 공연장 조회 시 404")
    void getUnknown() throws Exception {
        when(getVenueService.get(999L)).thenThrow(new VenueNotFoundException(999L));

        mockMvc.perform(get("/api/v1/venues/{id}", 999L))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.errors[0].field").value("venueId"));
    }
}
