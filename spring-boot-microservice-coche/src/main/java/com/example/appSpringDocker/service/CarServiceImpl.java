package com.example.appSpringDocker.service;

import com.example.appSpringDocker.model.CarDTO;
import com.example.appSpringDocker.repositoty.CarRepository;
import com.example.appSpringDocker.model.CarEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;


    @Override
    public Optional<CarDTO> saveCar(CarDTO dto) {
        //Guarda entidad
        CarEntity carSaved = carRepository.save(
                CarEntity.builder()
                        .enrollment(dto.getEnrollment())
                        .brand(dto.getBrand())
                        .model(dto.getModel())
                        .yearOfManufacture(dto.getYearOfManufacture())
                        .cc(dto.getCc())
                        .cv(dto.getCv()).build());
        //Retorna objeto DTO
        return Optional.of(CarDTO.builder()
                .id(carSaved.getId())
                .enrollment(carSaved.getEnrollment())
                .brand(carSaved.getBrand())
                .model(carSaved.getModel())
                .yearOfManufacture(carSaved.getYearOfManufacture())
                .cv(carSaved.getCv())
                .cc(carSaved.getCc()).build());
    }

    @Override
    public Optional<CarDTO> findById(Long carId) {
        //Busca obj en base de datos
        Optional<CarEntity> car = carRepository.findById(carId);
        //Lo retorna en forma de DTO
        return car.map(carEntity ->
                CarDTO.builder()
                        .id(carEntity.getId())
                        .enrollment(carEntity.getEnrollment())
                        .brand(carEntity.getBrand())
                        .model(carEntity.getModel())
                        .yearOfManufacture(carEntity.getYearOfManufacture())
                        .cv(carEntity.getCv())
                        .cc(carEntity.getCc())
                        .build() );
    }

    @Override
    public List<CarDTO> findAllCars() {
        //Obtiene la lista de todos los coches
        List<CarEntity> listCars = carRepository.findAll();
        //retorna la lista mapeada a dto
        return listCars.stream().map(carEntity ->
                        CarDTO.builder()
                                .id(carEntity.getId())
                                .enrollment(carEntity.getEnrollment())
                                .brand(carEntity.getBrand())
                                .model(carEntity.getModel())
                                .yearOfManufacture(carEntity.getYearOfManufacture())
                                .cc(carEntity.getCc())
                                .cv(carEntity.getCv()).build())
                .toList();
    }

    @Override
    public Optional<CarDTO> updateCar(Long id, CarDTO dto) {
        Optional<CarEntity> car = carRepository.findById(id);
        if (car.isPresent()){
            //Actualiza objeto
            car.get().setEnrollment(dto.getEnrollment());
            car.get().setBrand(dto.getBrand());
            car.get().setModel(dto.getModel());
            car.get().setYearOfManufacture(dto.getYearOfManufacture());
            car.get().setCv(dto.getCv());
            car.get().setCc(dto.getCc());
            //Guarda objeto actualizado
            CarEntity carUpdated = carRepository.save(car.get());
            //Retorna dto del objeto actualizado
            return Optional.of(CarDTO.builder()
                    .id(carUpdated.getId())
                    .enrollment(carUpdated.getEnrollment())
                    .brand(carUpdated.getBrand())
                    .model(carUpdated.getModel())
                    .yearOfManufacture(carUpdated.getYearOfManufacture())
                    .cc(carUpdated.getCc())
                    .cv(carUpdated.getCv()).build());
        }
        return Optional.empty();
    }

    @Override
    public void deleteCar(Long id) throws EntityNotFoundException {
        boolean carExist = carRepository.existsById(id);
        if (carExist) {
            carRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException();
        }
    }
}
