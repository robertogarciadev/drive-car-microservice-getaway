package com.example.app.springDocker.spring_boot_microservice_conductor.controller;


import com.example.app.springDocker.spring_boot_microservice_conductor.model.DriverDTO;
import com.example.app.springDocker.spring_boot_microservice_conductor.service.DriverService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @GetMapping("/{id}")
    public DriverDTO findDriverById(@PathVariable("id") Long id){
        Optional<DriverDTO> driverDTO = driverService.findDriverById(id);
        return driverDTO.orElse(null);
    }

    @PostMapping
    public DriverDTO saveDrive(@RequestBody DriverDTO dto){
        Optional<DriverDTO> driverDTO = driverService.saveDriver(dto);
        return driverDTO.orElse(null);
    }

    @GetMapping
    public List<DriverDTO> findAllDrivers(){
        return driverService.findAllDrivers();
    }

    @PutMapping("/{id}")
    public DriverDTO updateDriver(@PathVariable Long id, @RequestBody DriverDTO dto){
        Optional<DriverDTO> driver = driverService.updateDriver(id, dto);
        return driver.orElse(null);
    }

    @DeleteMapping("/{id}")
    public boolean deleteDriver(@PathVariable Long id){
        try{
            driverService.deleteDriver(id);
            return true;
        }catch (EntityNotFoundException e){
            return false;
        }
    }
}
