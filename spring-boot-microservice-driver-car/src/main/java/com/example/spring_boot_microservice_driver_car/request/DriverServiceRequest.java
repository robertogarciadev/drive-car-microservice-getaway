package com.example.spring_boot_microservice_driver_car.request;

import com.example.spring_boot_microservice_driver_car.model.DriverDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@FeignClient(
        value = "driver-service",
        path = "/api/driver",
        url = "${driver.service.url}"
)
public interface DriverServiceRequest {

    @GetMapping("/{id}")
    DriverDTO findById(@PathVariable("id") Long id);

    @PostMapping
    DriverDTO saveDriver(@RequestBody DriverDTO dto);

    @GetMapping
    List<DriverDTO> findAllDrivers();

    @PutMapping("/{id}")
    DriverDTO updateDriver(@PathVariable("id") Long id, @RequestBody DriverDTO dto);

    @DeleteMapping("/{id}")
    boolean deleteById(@PathVariable("id") Long id);

}
