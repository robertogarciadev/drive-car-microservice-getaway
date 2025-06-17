package com.example.app.springDocker.spring_boot_microservice_conductor.service;


import com.example.app.springDocker.spring_boot_microservice_conductor.model.DriverDTO;
import com.example.app.springDocker.spring_boot_microservice_conductor.model.DriverEntity;

import java.util.List;
import java.util.Optional;

public interface DriverService {

    Optional<DriverDTO> findDriverById(Long id);
    Optional<DriverDTO> saveDriver(DriverDTO driver);
    List<DriverDTO> findAllDrivers();
    Optional<DriverDTO> updateDriver(Long id, DriverDTO driver);
    void deleteDriver(Long id);

}
