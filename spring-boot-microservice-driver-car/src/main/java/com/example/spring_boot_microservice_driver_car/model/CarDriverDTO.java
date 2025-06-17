package com.example.spring_boot_microservice_driver_car.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDriverDTO implements Serializable {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("carId")
    private Long carId;

    @JsonProperty("driverId")
    private Long driverId;
}
