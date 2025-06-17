package com.example.spring_boot_microservice_api_getway.service;

import com.example.spring_boot_microservice_api_getway.model.CarDTO;
import com.example.spring_boot_microservice_api_getway.request.CarServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    CarServiceRequest carServiceRequest;


    public Optional<CarDTO> saveCar(CarDTO dto){
        return Optional.ofNullable(carServiceRequest.saveCar(dto));
    }

    public Optional<CarDTO> findCarByID(Long id){
        return Optional.ofNullable(carServiceRequest.findCarById(id));
    }

    public List<CarDTO> findAllCars(){
        return carServiceRequest.finAllCars();
    }

    public Optional<CarDTO> updateCar(Long id, CarDTO dto){
        return  Optional.ofNullable(carServiceRequest.updateCar(id, dto));
    }

    public boolean deleteCarById(Long id){
        return carServiceRequest.deleteById(id);
    }


}
