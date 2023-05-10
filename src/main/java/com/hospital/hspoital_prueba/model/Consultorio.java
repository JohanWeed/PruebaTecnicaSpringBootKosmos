package com.hospital.hspoital_prueba.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "consultorio")
public class Consultorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_consultorio")
    private int numeroConsultorio;

    private int piso;

    @OneToMany(mappedBy = "consultorio")
    private List<Cita> Cita;


    public Consultorio(){

    }
    public Consultorio(int numeroConsultorio, int piso){
        this.numeroConsultorio = numeroConsultorio;
        this.piso = piso;
    }

    public int getNumero(){return numeroConsultorio;};
    public void setNumero(int numeroConsultorio){this.numeroConsultorio = numeroConsultorio;};

    public int getPiso(){return piso;};
    public void setPiso(int piso){this.piso = piso;};
}
