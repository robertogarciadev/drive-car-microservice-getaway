package com.example.spring_boot_microservice_driver_car.service;

import com.example.spring_boot_microservice_driver_car.model.*;
import com.example.spring_boot_microservice_driver_car.repository.CarDriverRepository;
import com.example.spring_boot_microservice_driver_car.request.CarServiceRequest;
import com.example.spring_boot_microservice_driver_car.request.DriverServiceRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarDriverService {

    @Autowired
    CarDriverRepository carDriverRepository;
    @Autowired
    CarServiceRequest carServiceRequest;
    @Autowired
    DriverServiceRequest driverServiceRequest;


    public Optional<CarDriverDTO> saveCarDriver(Long carId, Long driverId){
        //Recupera coche y conductor
        CarDTO car = carServiceRequest.findCarById(carId);
        DriverDTO driver = driverServiceRequest.findById(driverId);

        //Comprueba si ya existe la asociación
        boolean existAssociation = carDriverRepository.findAll().stream()
                .anyMatch(item -> Objects.equals(item.getCarId(), carId) && Objects.equals(item.getDriverId(), driverId));

        if (!existAssociation && car != null && driver != null) {
            //Creaa y guarda nuevo objeto
            CarDriverEntity itemCreated = carDriverRepository.save(
                    CarDriverEntity.builder()
                            .carId(carId)
                            .driverId(driverId).build());
            //Lo retorna en forma de DTO
            return Optional.ofNullable(CarDriverDTO.builder()
                    .id(itemCreated.getId())
                    .carId(itemCreated.getCarId())
                    .driverId(itemCreated.getDriverId()).build());
        }else return Optional.empty();


    }

    public Optional<DriverWithCarsDTO> findDriverWithCarsById(Long driverId){
        //Obtiene Objeto de conductor y coches
        List<CarDriverEntity> list = carDriverRepository.findByDriverId(driverId);

        //Obtine conductor
        DriverDTO driver = driverServiceRequest.findById(driverId);
        if (driver==null){
            return Optional.empty();
        }

        //Obtien lista de coches
        List<CarDTO> listCars = list.stream()
                .map(CarDriverEntity::getCarId)
                .map(id-> carServiceRequest.findCarById(id))
                .toList();

        return  Optional.ofNullable(DriverWithCarsDTO.builder()
                .driver(driver)
                .listCars(listCars).build());
    }

    public Optional<CarWithDriversDTO> findCarWithDriversById(Long carId){
        List<CarDriverEntity> carDriverEntities = carDriverRepository.findByCarId(carId);

        //Obtiene coche
        CarDTO car = carServiceRequest.findCarById(carId);
        if (car==null){
            return Optional.empty();
        }

        //Obtiene lista de coches
        List<DriverDTO> listDrivers = carDriverEntities.stream()
                .map(CarDriverEntity::getDriverId)
                .map(id -> driverServiceRequest.findById(id))
                .toList();

        //Retorna consulta
        return Optional.ofNullable(CarWithDriversDTO.builder()
                .car(car)
                .listDrivers(listDrivers).build());
    }

    public List<CarDriverDTO> findAllCarDriver(){
        List<CarDriverEntity> list = carDriverRepository.findAll();
        return list.stream()
                .map(item-> CarDriverDTO.builder()
                        .id(item.getId())
                        .carId(item.getCarId())
                        .driverId(item.getDriverId()).build())
                .toList();
    }

    public void deleteCarDriver(Long id) throws EntityNotFoundException{
        if (carDriverRepository.existsById(id)){
            carDriverRepository.deleteById(id);
        }else{
            throw new EntityNotFoundException();
        }
    }
}
