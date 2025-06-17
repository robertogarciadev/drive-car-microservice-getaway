package com.example.spring_boot_microservice_api_getway.controller;


import com.example.spring_boot_microservice_api_getway.model.CarDTO;
import com.example.spring_boot_microservice_api_getway.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/gateway/car")
public class CarController {

    @Autowired
    CarService carService;


    @GetMapping("/{id}")
    public ResponseEntity<?> findCarById(@PathVariable("id") Long id){
        Optional<CarDTO> dto = carService.findCarByID(id);
        return dto.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(dto.get()) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping
    public ResponseEntity<?> findAllCars(){
        List<CarDTO> carsList = carService.findAllCars();

        return !carsList.isEmpty() ?
                ResponseEntity.status(HttpStatus.OK).body(carsList) :
                ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    public ResponseEntity<?> saveCar(@RequestBody CarDTO dto){
        Optional<CarDTO> carSaved =carService.saveCar(dto);
        return carSaved.isPresent() ?
                ResponseEntity.status(HttpStatus.CREATED).body(carSaved) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCar(@PathVariable("id")Long id, @RequestBody CarDTO dto){
        Optional<CarDTO> carDto = carService.updateCar(id, dto);
        return carDto.isPresent() ?
                ResponseEntity.status(HttpStatus.ACCEPTED).body(carDto) :
                ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCarById(@PathVariable("id")Long id){
        boolean deleteSuccess=carService.deleteCarById(id);
        return deleteSuccess ?
                ResponseEntity.status(HttpStatus.ACCEPTED).build():
                ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }

}
