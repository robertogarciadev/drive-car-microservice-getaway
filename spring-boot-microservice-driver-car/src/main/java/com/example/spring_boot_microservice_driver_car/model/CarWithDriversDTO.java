package com.example.spring_boot_microservice_driver_car.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarWithDriversDTO {

    @JsonProperty("car")
    private CarDTO car;
    @JsonProperty("listDrivers")
    private List<DriverDTO> listDrivers;
}
