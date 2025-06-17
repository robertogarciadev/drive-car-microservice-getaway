package com.example.spring_boot_microservice_api_getway.model;


import com.fasterxml.jackson.annotation.JsonProperty;
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
