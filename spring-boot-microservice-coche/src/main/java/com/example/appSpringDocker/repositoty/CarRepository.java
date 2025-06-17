package com.example.appSpringDocker.repositoty;

import com.example.appSpringDocker.model.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CarRepository extends JpaRepository<CarEntity, Long> {
}
