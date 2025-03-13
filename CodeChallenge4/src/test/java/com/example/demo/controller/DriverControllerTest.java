package com.example.demo.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.dto.DriverDTO;
import com.example.demo.dto.DriverRequest;
import com.example.demo.model.Driver;
import com.example.demo.service.DriverService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DriverController.class)
public class DriverControllerTest {

    @MockitoBean
    private DriverService driverService;

    @Autowired
    private MockMvc mockMvc;

    private DriverDTO driverDTO;

    @BeforeEach
    void setUp() {
        driverDTO = new DriverDTO(new Driver(1, "test name", 20, true));
    }

    @Test
    void testHelloWorld() throws Exception {
        mockMvc.perform(get("/api/v1/driver"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldSaveADriver() throws Exception {
        String json = "{\"name\": \"test name\", \"age\": 20}";
        when(driverService.saveDriver(new DriverRequest("test name", 20))).thenReturn(driverDTO);

        mockMvc.perform(post("/api/v1/driver/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldFindAll() throws Exception {
        when(driverService.saveDriver(new DriverRequest("test name", 20))).thenReturn(driverDTO);

        mockMvc.perform(get("/api/v1/driver/all"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldUpdateADriver() throws Exception {
        driverDTO = new DriverDTO(new Driver(1, "new name", 30, true));
        when(driverService.updateDriver(1, new DriverRequest("new name", 30))).thenReturn(driverDTO);

        String json = "{\"name\": \"new name\", \"age\": 30}";

        mockMvc.perform(put("/api/v1/driver/update/" + 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }

    @Test
    void shouldDeleteADriver() throws Exception {
        driverDTO = new DriverDTO(new Driver(1, "new name", 30, false));
        when(driverService.deleteDriver(1)).thenReturn(driverDTO);

        mockMvc.perform(delete("/api/v1/driver/delete/" + 1))
                .andExpect(status().isNoContent());
    }
}
