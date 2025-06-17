package com.example.appSpringDocker.service;


import com.example.appSpringDocker.model.CarDTO;
import com.example.appSpringDocker.model.CarEntity;

import java.util.List;
import java.util.Optional;

public interface CarService {

    Optional<CarDTO> saveCar(CarDTO user);
    Optional<CarDTO> findById(Long carId);
    List<CarDTO> findAllCars();
    Optional<CarDTO> updateCar(Long id, CarDTO carDTO);
    void deleteCar(Long id);

}
