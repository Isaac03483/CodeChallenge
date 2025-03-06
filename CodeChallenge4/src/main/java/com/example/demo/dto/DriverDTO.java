package com.example.demo.dto;

import com.example.demo.model.Driver;

public record DriverDTO(Integer id, String name, Integer age) {
    
    public DriverDTO(Driver driver) {
        this(driver.id(), driver.name(), driver.age());
    }
}
