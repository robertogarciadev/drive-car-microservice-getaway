package com.example.spring_boot_microservice_api_getway.request;

import com.example.spring_boot_microservice_api_getway.model.CarDriverDTO;
import com.example.spring_boot_microservice_api_getway.model.CarWithDriversDTO;
import com.example.spring_boot_microservice_api_getway.model.DriverWithCarsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        name = "carDrive-service",
        path = "api/car-driver",
        url = "${carDriver.service.url}"
)
public interface CarDriverServiceRequest {

    @GetMapping
    List<CarDriverDTO> findAllCarDriver();

    @GetMapping("/driver/{id}")
    DriverWithCarsDTO findDriverWithCars(@PathVariable("id")Long id);

    @GetMapping("/car/{id}")
    CarWithDriversDTO finCarsWithDrivers(@PathVariable("id")Long id);

    @PostMapping
    CarDriverDTO saveCarDriver(@RequestParam Long carId, @RequestParam Long driverId);

    @DeleteMapping("/{id}")
    boolean deleteById(@PathVariable("id") Long id);
}
