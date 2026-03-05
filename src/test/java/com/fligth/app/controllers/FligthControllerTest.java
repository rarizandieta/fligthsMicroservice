package com.fligth.app.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fligth.app.entities.Fligth;
import com.fligth.app.services.FligthService;

@ExtendWith(MockitoExtension.class)
class FligthControllerTest {

    private MockMvc mockMvc;

    @Mock
    private FligthService fligthService;

    @InjectMocks
    private FligthController fligthController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(fligthController).build();
    }

    @Test
    void findAll_returnsList() throws Exception {
        Fligth fligth = buildFligth(1L);
        when(fligthService.findAll()).thenReturn(List.of(fligth));

        mockMvc.perform(get("/api/fligths/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].flightNumber").value("FL-100"));
    }

    @Test
    void findById_returnsEntity_whenFound() throws Exception {
        Fligth fligth = buildFligth(2L);
        when(fligthService.findById(2L)).thenReturn(Optional.of(fligth));

        mockMvc.perform(get("/api/fligths/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2L))
                .andExpect(jsonPath("$.flightNumber").value("FL-100"));
    }

    @Test
    void findById_returns404_whenMissing() throws Exception {
        when(fligthService.findById(99L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/fligths/99"))
                .andExpect(status().isNotFound());
    }

    private Fligth buildFligth(Long id) {
        Fligth fligth = new Fligth();
        fligth.setId(id);
        fligth.setFlightNumber("FL-100");
        fligth.setAirline("ACME AIR");
        fligth.setOrigin("BOG");
        fligth.setDestination("MDE");
        fligth.setDepartureTime(LocalDateTime.now().plusHours(1));
        fligth.setArrivalTime(LocalDateTime.now().plusHours(2));
        fligth.setStatus("ON_TIME");
        fligth.setAircraftType("A320");
        fligth.setGate("A1");
        fligth.setPrice(new BigDecimal("199.99"));
        return fligth;
    }
}
