package com.hospital.hspoital_prueba.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.hspoital_prueba.model.Consultorio;

public interface ConsultorioRepository extends JpaRepository<Consultorio, Long> {
    Optional<Consultorio> findById(Long id);
}
