package com.example.spring_boot_microservice_api_getway.controller;

import com.example.spring_boot_microservice_api_getway.model.DriverDTO;
import com.example.spring_boot_microservice_api_getway.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/gateway/driver")
public class DriveController {

    @Autowired
    DriverService driverService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        Optional<DriverDTO> driver = driverService.findById(id);

        return driver.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(driver.get()):
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping
    public ResponseEntity<?> findAllDriver(){
        List<DriverDTO> listDrivers = driverService.findAllDrivers();
        return !listDrivers.isEmpty() ?
                ResponseEntity.status(HttpStatus.OK).body(listDrivers):
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    public ResponseEntity<?> saveDriver(@RequestBody DriverDTO dto){
        Optional<DriverDTO> driver = driverService.saveDriver(dto);
        return driver.isPresent() ?
                ResponseEntity.status(HttpStatus.CREATED).body(driver.get()):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDriver(@PathVariable("id") Long id,@RequestBody DriverDTO dto){
        Optional<DriverDTO> driver = driverService.updateDriver(id,dto);
        return driver.isPresent() ?
                ResponseEntity.status(HttpStatus.ACCEPTED).body(driver.get()):
                ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id")Long id){
        boolean deleteSuccess = driverService.deleteById(id);
        return deleteSuccess ?
                ResponseEntity.status(HttpStatus.ACCEPTED).build():
                ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }
}
