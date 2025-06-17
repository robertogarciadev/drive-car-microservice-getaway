package com.example.spring_boot_microservice_driver_car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringBootMicroserviceDriverCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroserviceDriverCarApplication.class, args);
	}

}
