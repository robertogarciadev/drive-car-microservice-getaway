package com.example.spring_boot_microservice_driver_car.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DriverWithCarsDTO {

    @JsonProperty("driver")
    private DriverDTO driver;

    @JsonProperty("listCars")
    private List<CarDTO> listCars;

}
