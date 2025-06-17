package com.example.spring_boot_microservice_driver_car.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "car_driver")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDriverEntity implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "car_id", nullable = false)
    private Long carId;

    @Column(name = "driver_id", nullable = false)
    private Long driverId;

}
