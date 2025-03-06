package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.DriverDTO;
import com.example.demo.exceptions.NotSavedException;
import com.example.demo.model.Driver;
import com.example.demo.repository.DriverRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Service
@AllArgsConstructor
@Getter
@Setter
public class DriverService {
    
    private final DriverRepository driverRepository;

    public DriverDTO saveDriver(String name, Integer age) {
        Optional<Driver> oDriver = this.driverRepository.findByName(name);
        if(oDriver.isPresent()) {
            throw new NotSavedException("Duplicated name");
        }

        Driver driver = new Driver(null, name, age);
        
        Driver saved = this.driverRepository.save(driver);
        return new DriverDTO(saved);
    }

    public List<DriverDTO> findAll() {
        List<Driver> driver = this.driverRepository.findAll();

        return driver.stream().map(DriverDTO::new).toList();
    }

}
