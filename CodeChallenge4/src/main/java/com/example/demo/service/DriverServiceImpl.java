package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.DriverDTO;
import com.example.demo.dto.DriverRequest;
import com.example.demo.exceptions.DriverException;
import com.example.demo.model.Driver;
import com.example.demo.repository.DriverRepository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@Getter
@Setter
public class DriverServiceImpl implements DriverService {
    
    private final DriverRepository driverRepository;

    @Override
    public DriverDTO saveDriver(DriverRequest request) {
        String name = request.name();
        Integer age = request.age();
        boolean exists = this.driverRepository.existsByName(name);
        if(exists) {
            throw new DriverException("Duplicated name");
        }

        Driver driver = new Driver(null, name, age, true);
        
        Driver saved = this.driverRepository.save(driver);
        return new DriverDTO(saved);
    }

    @Override
    public List<DriverDTO> findAll() {
        List<Driver> driver = this.driverRepository.findAll();

        return driver.stream().map(DriverDTO::new).toList();
    }

    @Override
    public DriverDTO updateDriver(Integer id, DriverRequest request) {
        String name = request.name();
        Integer age = request.age();
        
        boolean exists = this.driverRepository.existsByName(name);

        if(exists) {
            throw new DriverException("Duplicated name");
        }

        Optional<Driver> driverOptional = this.driverRepository.findById(id);
        if(driverOptional.isEmpty()) {
            throw new DriverException("Driver not found");
        }

        Driver driver = driverOptional.get();
        driver.setName(name);
        driver.setAge(age);

        Driver driverUpdated = this.driverRepository.save(driver);
        
        return new DriverDTO(driverUpdated);
    }

    @Override
    public DriverDTO deleteDriver(Integer id) {
        Optional<Driver> driverOptional = this.driverRepository.findById(id);

        if(driverOptional.isEmpty()) {
            throw new DriverException("Driver not found");
        }

        Driver driver = driverOptional.get();

        driver.setIsEnabled(false);
        Driver driverDeleted = this.driverRepository.save(driver);

        return new DriverDTO(driverDeleted);
    }
}
