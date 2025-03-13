package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DriverDTO;
import com.example.demo.dto.DriverRequest;
import com.example.demo.service.DriverService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/v1/driver")
@RequiredArgsConstructor
@Getter
@Setter
public class DriverController {

    private final DriverService driverService;

    @GetMapping("")
    public String helloWorld() {
        return "Hello world!";
    }

    @PostMapping("/save")
    public ResponseEntity<DriverDTO> saveDriver(@RequestBody DriverRequest request) {
        DriverDTO driverDTO = this.driverService.saveDriver(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(driverDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<DriverDTO>> findAll() {
        List<DriverDTO> list = this.driverService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DriverDTO> updateDriver(@PathVariable Integer id, @RequestBody DriverRequest driverRequest) {
        DriverDTO driverDTO = this.driverService.updateDriver(id, driverRequest);
        return ResponseEntity.status(HttpStatus.OK).body(driverDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Integer id) {
        this.driverService.deleteDriver(id);    
        return ResponseEntity.noContent().build();
    }
    
}
