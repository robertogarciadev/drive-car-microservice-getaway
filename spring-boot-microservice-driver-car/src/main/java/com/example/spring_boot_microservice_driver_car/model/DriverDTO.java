package com.example.spring_boot_microservice_driver_car.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverDTO implements Serializable {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("licenseNumber")
    private String licenseNumber;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("email")
    private String email;
}
