package com.hospital.hspoital_prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.hospital.hspoital_prueba.repositories")
public class HspoitalPruebaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HspoitalPruebaApplication.class, args);
	}

}
