package com.example.spring_boot_microservice_driver_car.controller;

import com.example.spring_boot_microservice_driver_car.model.CarDriverDTO;
import com.example.spring_boot_microservice_driver_car.model.CarDriverEntity;
import com.example.spring_boot_microservice_driver_car.model.CarWithDriversDTO;
import com.example.spring_boot_microservice_driver_car.model.DriverWithCarsDTO;
import com.example.spring_boot_microservice_driver_car.service.CarDriverService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/car-driver")
public class CarDriverController {

    @Autowired
    CarDriverService carDriverService;

    @GetMapping
    public List<CarDriverDTO> findAllCarDriver(){
        return carDriverService.findAllCarDriver();
    }

    @GetMapping("/driver/{id}")
    public DriverWithCarsDTO findDriverWithCarById(@PathVariable("id") Long id){
        return carDriverService.findDriverWithCarsById(id).orElse(null);

    }

    @GetMapping("/car/{id}")
    public CarWithDriversDTO findCarWithDriversById(@PathVariable("id") Long id){
        return carDriverService.findCarWithDriversById(id).orElse(null);
    }

    @PostMapping
    public CarDriverDTO saveCarDriver(@RequestParam Long carId, @RequestParam Long driverId){
        return carDriverService.saveCarDriver(carId, driverId).orElse(null);

    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable("id") Long id){
        try{
            carDriverService.deleteCarDriver(id);
            return true;
        }catch (EntityNotFoundException e){
            return false;
        }
    }


}
