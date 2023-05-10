package com.hospital.hspoital_prueba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hospital.hspoital_prueba.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    List<Doctor> findAll();

    @Query("SELECT DISTINCT d.especialidad FROM Doctor d")
    List<String> findDistinctEspecialidades();

}
