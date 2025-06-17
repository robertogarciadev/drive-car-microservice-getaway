package com.example.spring_boot_microservice_api_getway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringBootMicroserviceApiGetwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroserviceApiGetwayApplication.class, args);
	}

}
