package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.model.Driver;

public class DriverRepositoryTest {

    @Mock
    private DriverRepository driverRepository;
    private Driver driver;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    void shouldSaveADriver() {
        Driver expected = new Driver(1, "test name", 20, true);

        //Given driver
        driver = new Driver(null, "test name", 20, true);
        
        //When
        when(this.driverRepository.save(driver)).thenReturn(expected);
        Driver actual = this.driverRepository.save(driver);

        String expectedName = "test name";
        assertNotNull(actual);
        assertEquals(expectedName, actual.getName());
        assertEquals(expected, actual);
    }

    @Test
    void shouldListAll() {
        Driver expected = new Driver(1, "test name", 20, true);

        //Given driver
        driver = new Driver(null, "test name", 20, true);
        
        //When
        when(this.driverRepository.save(driver)).thenReturn(expected);
        when(this.driverRepository.findAll()).thenReturn(List.of(expected));
        this.driverRepository.save(driver);

        List<Driver> expectedList = List.of(expected);
        List<Driver> actualList = this.driverRepository.findAll();

        assertEquals(expectedList, actualList);
    }
}
