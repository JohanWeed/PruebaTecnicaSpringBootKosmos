package com.hospital.hspoital_prueba.model;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "cita")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "horario_cita")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime horarioCita;

    private String nombrePaciente;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor = new Doctor();

    @ManyToOne
    @JoinColumn(name = "consultorio_id")
    private Consultorio consultorio = new Consultorio();

    public Cita(){

    }
    public Cita(Consultorio consultorio, Doctor doctor, LocalDateTime horarioCita, String nombrePaciente){
        this.consultorio = consultorio;
        this.doctor = doctor;
        this.horarioCita = horarioCita;
        this.nombrePaciente = nombrePaciente;
    }

    
    public Consultorio getConsultorio() {return consultorio;}

    public void setConsultorio(Consultorio consultorio) {this.consultorio = consultorio;}

    public Doctor getDoctor() {return doctor;}

    public void setDoctor(Doctor doctor) {this.doctor = doctor;}

    public LocalDateTime getHorarioCita() {return horarioCita;}

    public void setHorarioCita(LocalDateTime horarioCita) {this.horarioCita = horarioCita;}

    public String getNombrePaciente() {return nombrePaciente;}

    public void setNombrePaciente(String nombrePaciente) {this.nombrePaciente = nombrePaciente;}



}
