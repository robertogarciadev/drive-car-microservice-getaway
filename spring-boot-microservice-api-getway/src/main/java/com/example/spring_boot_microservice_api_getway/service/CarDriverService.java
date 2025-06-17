package com.example.spring_boot_microservice_api_getway.service;

import com.example.spring_boot_microservice_api_getway.model.CarDriverDTO;
import com.example.spring_boot_microservice_api_getway.model.CarWithDriversDTO;
import com.example.spring_boot_microservice_api_getway.model.DriverWithCarsDTO;
import com.example.spring_boot_microservice_api_getway.request.CarDriverServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarDriverService {

    @Autowired
    CarDriverServiceRequest carDriverServiceRequest;

    public List<CarDriverDTO> findAllCarDriver(){
        return  carDriverServiceRequest.findAllCarDriver();
    }

    public Optional<DriverWithCarsDTO> findDriverWithCar(Long id){
        return Optional.ofNullable(carDriverServiceRequest.findDriverWithCars(id));
    }
    public Optional<CarWithDriversDTO> findCarWithDrivers(Long id){
        return Optional.ofNullable(carDriverServiceRequest.finCarsWithDrivers(id));
    }
    public Optional<CarDriverDTO> saveCarDriver(Long idCar, Long idDriver){
        return Optional.ofNullable(
                carDriverServiceRequest.saveCarDriver(idCar, idDriver)
        ) ;
    }
    public boolean deleteById(Long id){
        return carDriverServiceRequest.deleteById(id);
    }
}
