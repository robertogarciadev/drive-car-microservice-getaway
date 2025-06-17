package com.example.app.springDocker.spring_boot_microservice_conductor.repository;

import com.example.app.springDocker.spring_boot_microservice_conductor.model.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<DriverEntity, Long> {


}
