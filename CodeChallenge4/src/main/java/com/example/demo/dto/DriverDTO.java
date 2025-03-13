package com.example.demo.dto;

import com.example.demo.model.Driver;

public record DriverDTO(Integer id, String name, Integer age, Boolean isEnabled) {
    
    public DriverDTO(Driver driver) {
        this(driver.getId(), driver.getName(), driver.getAge(), driver.getIsEnabled());
    }
}
