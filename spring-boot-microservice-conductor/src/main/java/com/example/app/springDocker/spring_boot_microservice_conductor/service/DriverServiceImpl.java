package com.example.app.springDocker.spring_boot_microservice_conductor.service;

import com.example.app.springDocker.spring_boot_microservice_conductor.model.DriverDTO;
import com.example.app.springDocker.spring_boot_microservice_conductor.model.DriverEntity;
import com.example.app.springDocker.spring_boot_microservice_conductor.repository.DriverRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService{

    @Autowired
    DriverRepository driverRepository;


    @Override
    public Optional<DriverDTO> findDriverById(Long id) {
        //Guarda y devuelve el objeto
        Optional<DriverEntity> driver = driverRepository.findById(id);
        //Pasa el objeto a DTO y lo retorna
        return driver.map(driverEntity->
            DriverDTO.builder()
                    .id(driverEntity.getId())
                    .name(driverEntity.getName())
                    .licenseNumber(driverEntity.getLicenseNumber())
                    .phone(driverEntity.getPhone())
                    .email(driverEntity.getEmail())
                    .build());
    }

    @Override
    public Optional<DriverDTO> saveDriver(DriverDTO driver) {

        //Paso de DTO a Entity
        DriverEntity newDriver = DriverEntity.builder()
                .name(driver.getName())
                .licenseNumber(driver.getLicenseNumber())
                .phone(driver.getPhone())
                .email(driver.getEmail())
                .build();

        //Guarda y retorna el Objeto
        newDriver = driverRepository.save(newDriver);

        //Devuelve DTO del Objeto guardado
        return Optional.of(DriverDTO.builder()
                .id(newDriver.getId())
                .name(newDriver.getName())
                .licenseNumber(newDriver.getLicenseNumber())
                .phone(newDriver.getPhone())
                .email(newDriver.getEmail())
                .build());
    }

    @Override
    public List<DriverDTO> findAllDrivers() {
        List<DriverEntity> allDrivers = driverRepository.findAll();
        return allDrivers.stream()
                .map(driverEntity -> DriverDTO.builder()
                        .id(driverEntity.getId())
                        .name(driverEntity.getName())
                        .licenseNumber(driverEntity.getLicenseNumber())
                        .phone(driverEntity.getPhone())
                        .email(driverEntity.getEmail()).build())
                .toList();
    }

    @Override
    public Optional<DriverDTO> updateDriver(Long id, DriverDTO driver) {
        //Busca a entidad
        Optional<DriverEntity> driverEntity = driverRepository.findById(id);

        if (driverEntity.isPresent()){
            //Si existe, actualiza los campos
            driverEntity.get().setName(driver.getName());
            driverEntity.get().setLicenseNumber(driver.getLicenseNumber());
            driverEntity.get().setPhone(driver.getPhone());
            driverEntity.get().setEmail(driver.getEmail());

            //Guarda cambios en base de datos
            DriverEntity driverUpdate = driverRepository.save(driverEntity.get());

            //Devuelve objeto actualizado
            return Optional.of(DriverDTO.builder()
                    .id(driverUpdate.getId())
                    .name(driverUpdate.getName())
                    .licenseNumber(driverUpdate.getLicenseNumber())
                    .phone(driver.getPhone())
                    .email(driverUpdate.getEmail()).build());
        }else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public void deleteDriver(Long id) throws EntityNotFoundException {
        //Comprueba si existe la entidad por ID
        boolean existEntity = driverRepository.existsById(id);
        if (existEntity){
            //Borra la entidad
            driverRepository.deleteById(id);
        }else{
             throw new EntityNotFoundException();
        }
    }
}
