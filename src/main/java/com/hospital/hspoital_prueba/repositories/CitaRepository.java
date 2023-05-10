package com.hospital.hspoital_prueba.repositories;

import com.hospital.hspoital_prueba.model.Cita;
import com.hospital.hspoital_prueba.model.Consultorio;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {

    @Query("SELECT c.consultorio FROM Cita c WHERE c.horarioCita = :horarioCita")
    List<Consultorio> findAvailableConsultorios(@Param("horarioCita") LocalDateTime horarioCita);

    List<Cita> findByConsultorioAndHorarioCitaBetween(Consultorio consultorio, LocalDateTime startDateTime,
            LocalDateTime endDateTime);

    default void saveCita(Cita cita) {
        save(cita);
    }

    default boolean isConsultorioAvailable(Consultorio consultorio, LocalDateTime horarioCita) {

        // Verificar si existen citas previas que se superpongan con el horario deseado
        List<Cita> citas = findByConsultorioAndHorarioCitaBetween(consultorio, horarioCita,
                horarioCita.plusMinutes(30));

        // Si no hay citas previas que se superpongan, el consultorio está disponible
        return citas.isEmpty();
    }

    // Otros métodos del repositorio...
}
