package com.hospital.hspoital_prueba.repositories;

import com.hospital.hspoital_prueba.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
    
}
