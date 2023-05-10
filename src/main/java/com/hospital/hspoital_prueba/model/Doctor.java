package com.hospital.hspoital_prueba.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name="apellido_paterno")
    private String apellidoMaterno;

    @Column(name = "apellido_materno")
    private String apellidoPaterno;

    private String especialidad;
    
    @OneToMany(mappedBy = "doctor")
    private List<Cita> citas;


    public Doctor(){

    }
    public Doctor(String nombre, String apellidoMaterno,String apellidoPaterno, String especialidad){
        this.nombre = nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.especialidad = especialidad;
    };

    public String getNombres(){return nombre;};
    public void setNombres(String nombres){this.nombre=nombres;}

    public String getApellidoMaterno(){return apellidoMaterno;};
    public void setApellidoMaterno(String apellidoMaterno){this.apellidoMaterno=apellidoMaterno;};

    public String getApellidoPaterno(){return apellidoPaterno;};
    public void setApellidoPaterno(String apellidoPaterno){this.apellidoPaterno=apellidoPaterno;};

    public String getEspecialidad(){return especialidad;};
    public void setEspecialidad(String especialidad){this.especialidad = especialidad;};


}