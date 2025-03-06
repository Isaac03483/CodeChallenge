package com.example.demo.controller;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.dto.DriverDTO;
import com.example.demo.dto.DriverRequest;
import com.example.demo.model.Driver;
import com.example.demo.service.DriverService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DriverController.class)
public class DriverControllerTest {

    @MockBean
    private DriverService driverService;

    @Autowired
    private MockMvc mockMvc;

    private DriverDTO driverDTO;
    private List<DriverDTO> list;

    @BeforeEach
    void setUp() {
        driverDTO = new DriverDTO(new Driver(1, "test name", 20));
        list = List.of(driverDTO);
    }

    @Test
    void testHelloWorld() throws Exception {
        mockMvc.perform(get("/api/v1/driver"))
                .andExpect(status().isOk());
    }

    @Test
    void save() throws Exception {
        DriverRequest driverRequest = new DriverRequest("test name", 20);
        String json = "{'name': '" + driverRequest.name() + "', 'age': '" + driverRequest.age() + "'}";
        when(driverService.saveDriver("test name", 20)).thenReturn(driverDTO);

        mockMvc.perform(post("/api/v1/driver/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }

    @Test
    void shouldFindAll() throws Exception {
        when(driverService.saveDriver("test name", 20)).thenReturn(driverDTO);

        mockMvc.perform(get("/api/v1/driver/all"))
                .andExpect(status().isOk());
    }
}
