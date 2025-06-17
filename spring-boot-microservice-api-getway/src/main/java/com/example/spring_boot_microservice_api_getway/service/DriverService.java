package com.example.spring_boot_microservice_api_getway.service;

import com.example.spring_boot_microservice_api_getway.model.CarDTO;
import com.example.spring_boot_microservice_api_getway.model.DriverDTO;
import com.example.spring_boot_microservice_api_getway.request.DriverServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    DriverServiceRequest driverServiceRequest;

    public Optional<DriverDTO> findById(Long id){
        return Optional.ofNullable(driverServiceRequest.findById(id));
    }

    public List<DriverDTO> findAllDrivers(){
        return driverServiceRequest.findAllDrivers();
    }

    public Optional<DriverDTO> saveDriver(DriverDTO dto){
        return Optional.ofNullable(driverServiceRequest.saveDriver(dto));
    }

    public Optional<DriverDTO> updateDriver(Long id, DriverDTO dto){
        return Optional.ofNullable(driverServiceRequest.updateDriver(id, dto));
    }

    public boolean deleteById(Long id){
        return driverServiceRequest.deleteById(id);
    }
}
