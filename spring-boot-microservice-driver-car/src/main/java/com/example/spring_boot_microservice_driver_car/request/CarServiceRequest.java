package com.example.spring_boot_microservice_driver_car.request;

import com.example.spring_boot_microservice_driver_car.model.CarDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        value = "car-service",
        path = "/api/car",
        url = "${car.service.url}"
)
public interface CarServiceRequest {

    @PostMapping
    CarDTO saveCar(CarDTO DTO);

    @GetMapping("/{id}")
    CarDTO findCarById(@PathVariable("id") Long id);

    @GetMapping
    List<CarDTO> finAllCars();

    @PutMapping("/{id}")
    CarDTO updateCar(@PathVariable("id") Long id,@RequestBody CarDTO dto);

    @DeleteMapping("/{id}")
    boolean deleteById(@PathVariable("id") Long id);

}
