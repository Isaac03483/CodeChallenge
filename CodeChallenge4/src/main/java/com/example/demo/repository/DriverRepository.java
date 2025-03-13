package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer>  {
    
    boolean existsByName(String name);
}
