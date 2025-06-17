package com.example.spring_boot_microservice_driver_car.repository;

import com.example.spring_boot_microservice_driver_car.model.CarDriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarDriverRepository extends JpaRepository<CarDriverEntity, Long> {

    List<CarDriverEntity> findByDriverId(Long id);
    List<CarDriverEntity> findByCarId(Long id);
}
