package com.example.appSpringDocker.controller;


import com.example.appSpringDocker.model.CarDTO;
import com.example.appSpringDocker.service.CarService;
import com.example.appSpringDocker.model.CarEntity;
import com.example.appSpringDocker.util.ErrorResponseEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/car")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping
    public CarDTO saveCar(@RequestBody CarDTO dto){
        //Guarda objeto
        Optional<CarDTO> car = carService.saveCar(dto);
        return car.orElse(null);
    }


    @GetMapping(value = "/{id}")
    public CarDTO findCarById(@PathVariable("id") Long id){
        //Recupera objeto de la base de datos a través del servicio
        Optional<CarDTO> car = carService.findById(id);
        return car.orElse(null);
    }

    @GetMapping
    public List<CarDTO> findAllCars(){
        return  carService.findAllCars();
    }

    @PutMapping("/{id}")
    public CarDTO updateCar(@PathVariable("id") Long id, @RequestBody CarDTO dto){
        Optional<CarDTO> carUpdated = carService.updateCar(id, dto);
        return  carUpdated.orElse(null);
    }


    @DeleteMapping("/{id}")
    public boolean deleteCar(@PathVariable("id") Long id){
        try {
            carService.deleteCar(id);
            return true;
        }catch (EntityNotFoundException e){
            return false;
        }
    }
}
