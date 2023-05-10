package com.hospital.hspoital_prueba.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.hospital.hospital_prueba.repositories")
public class JpaConfig {

}
