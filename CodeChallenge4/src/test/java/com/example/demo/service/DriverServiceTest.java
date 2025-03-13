package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.dto.DriverDTO;
import com.example.demo.dto.DriverRequest;
import com.example.demo.exceptions.DriverException;
import com.example.demo.model.Driver;
import com.example.demo.repository.DriverRepository;

public class DriverServiceTest {

    private DriverService driverService;

    @Mock
    private DriverRepository driverRepository;

    DriverRequest request;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        driverService = new DriverServiceImpl(driverRepository);
    }
    
    @Test
    void testSaveDriver() {
        //Given
        request = new DriverRequest("test name", 20);

        // When
        Driver driver = new Driver(1, "test name", 20, true);
        when(this.driverRepository.save(any(Driver.class))).thenReturn(driver);

        // Then
        DriverDTO expected = new DriverDTO(driver);

        DriverDTO actual = this.driverService.saveDriver(request);

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotSave() {
        //Given
        request = new DriverRequest("test name", 20);

        // When
        when(this.driverRepository.existsByName("test name")).thenReturn(true);

        // Then
        Exception exception = assertThrows(DriverException.class, () -> {
            this.driverService.saveDriver(request);
        });

        String expectedMessage = "Duplicated name";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
        
    }

    @Test 
    void shouldFindAll() {
        //Given

        // When
        Driver driver = new Driver(1, "test name", 20, true);
        when(this.driverRepository.findAll()).thenReturn(List.of(driver));

        // Then
        List<DriverDTO> expected = List.of(new DriverDTO(driver));

        List<DriverDTO> actual = this.driverService.findAll();

        assertEquals(expected, actual);
    }

    @Test
    void shouldUpdateADriver() {
        // Given
        request = new DriverRequest("test name", 25);
        DriverRequest request2 = new DriverRequest("new name", 30);

        Driver driver = new Driver(1, "test name", 25, true);
        Driver driver2 = new Driver(1, "new name", 30, true);

        // when
        when(this.driverRepository.existsByName("new name")).thenReturn(false);
        when(this.driverRepository.findById(1)).thenReturn(Optional.of(driver));
        when(this.driverRepository.save(any(Driver.class))).thenReturn(driver2);

        DriverDTO expected = new DriverDTO(driver2);

        DriverDTO actual = this.driverService.updateDriver(1, request2);

        assertEquals(expected, actual);

    }

    @Test
    void shouldFindDuplicatedName() {
        // Given
        request = new DriverRequest("new name", 30);

        // When
        when(this.driverRepository.existsByName("new name")).thenReturn(true);
        
        Exception exception = assertThrows(DriverException.class, () -> {
            this.driverService.updateDriver(1, request);
        });

        String expectedMessage = "Duplicated name";

        String actualMessage = exception.getMessage();

        // Then
        assertEquals(expectedMessage, actualMessage);
    }
    
    @Test
    void shouldNotFindIdToUpdate() {
        // Given
        request = new DriverRequest("new name", 30);

        // When
        when(this.driverRepository.findById(1)).thenReturn(Optional.empty());


        Exception exception = assertThrows(DriverException.class, () -> {
            this.driverService.updateDriver(1, request);
        });

        String expectedMessage = "Driver not found";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    void shouldDeleteADriver() {
        // Given
        Driver driver = new Driver(1, "test name", 25, true);

        // When
        when(this.driverRepository.findById(1)).thenReturn(Optional.of(driver));
        driver.setIsEnabled(false);
        when(this.driverRepository.save(any(Driver.class))).thenReturn(driver);
        
        
        DriverDTO expected = new DriverDTO(driver);

        DriverDTO actual = this.driverService.deleteDriver(1);

        // Then
        assertEquals(expected, actual);
        assertFalse(actual.isEnabled());


    }

    @Test
    void shouldNotFindIdToDelete() {

        // When
        when(this.driverRepository.findById(1)).thenReturn(Optional.empty());

        Exception exception = assertThrows(DriverException.class, () -> {
            this.driverService.deleteDriver(1);
        });

        String expectedMessage = "Driver not found";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);


    }
}
