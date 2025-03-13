package com.example.demo.service;

import java.util.List;


import com.example.demo.dto.DriverDTO;
import com.example.demo.dto.DriverRequest;

public interface DriverService {

    DriverDTO saveDriver(DriverRequest request);

    List<DriverDTO> findAll();

    DriverDTO updateDriver(Integer id, DriverRequest request);

    DriverDTO deleteDriver(Integer id);
}
