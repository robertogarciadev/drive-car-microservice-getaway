package com.example.spring_boot_microservice_api_getway.model;

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
public class CarDTO implements Serializable {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("enrollment")
    private String enrollment;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("model")
    private String model;

    @JsonProperty("yearOfManufacture")
    private Integer yearOfManufacture;

    @JsonProperty("cv")
    private Integer cv;

    @JsonProperty("cc")
    private Integer cc;

}
