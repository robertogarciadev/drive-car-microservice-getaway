package com.example.spring_boot_microservice_api_getway.controller;

import com.example.spring_boot_microservice_api_getway.model.CarDriverDTO;
import com.example.spring_boot_microservice_api_getway.model.CarWithDriversDTO;
import com.example.spring_boot_microservice_api_getway.model.DriverWithCarsDTO;
import com.example.spring_boot_microservice_api_getway.service.CarDriverService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/gateway/car-drive")
public class CarDriverController {

    @Autowired
    CarDriverService carDriverService;

    @GetMapping
    public ResponseEntity<?> findAllCarDrivers(){
        List<CarDriverDTO> list = carDriverService.findAllCarDriver();
        return  !list.isEmpty() ?
                ResponseEntity.status(HttpStatus.OK).body(list) :
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/driver/{id}")
    public ResponseEntity<?> findDriveWithCars(@PathVariable("id") Long id){
        Optional<DriverWithCarsDTO> driverWithCars = carDriverService.findDriverWithCar(id);
        return driverWithCars.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(driverWithCars.get()):
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<?> findCarWithDrivers (@PathVariable("id")Long id){
        Optional<CarWithDriversDTO> carWithDrivers = carDriverService.findCarWithDrivers(id);
        return carWithDrivers.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(carWithDrivers.get()):
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<?> saveCarDriver(@RequestParam Long idCar, @RequestParam Long idDriver){
        Optional<CarDriverDTO> carDriver = carDriverService.saveCarDriver(idCar, idDriver);

        return carDriver.isPresent() ?
                ResponseEntity.status(HttpStatus.CREATED).body(carDriver.get()) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id ){
        boolean deleteSuccess = carDriverService.deleteById(id);
        return deleteSuccess ?
                ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }

}
