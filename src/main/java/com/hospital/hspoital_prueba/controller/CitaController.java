package com.hospital.hspoital_prueba.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

import com.hospital.hspoital_prueba.repositories.CitaRepository;
//import com.hospital.hspoital_prueba.repositories.ConsultorioRepository;
import com.hospital.hspoital_prueba.repositories.DoctorRepository;

import com.hospital.hspoital_prueba.model.Doctor;
import com.hospital.hspoital_prueba.model.Cita;
import com.hospital.hspoital_prueba.model.Consultorio;

@Controller
public class CitaController {

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private DoctorRepository doctorRepository;


    @GetMapping("/citas/agregar")
    public String showAddCitaForm(Model model) {
        List<String> especialidades = doctorRepository.findDistinctEspecialidades();
        List<Doctor> doctores = doctorRepository.findAll();

        model.addAttribute("especialidades", especialidades);
        model.addAttribute("doctores", doctores);
        model.addAttribute("cita", new Cita());
        return "add-cita";
    }

    @PostMapping("/citas/agregar")
    public String addCita(@ModelAttribute("cita") Cita cita) {

        LocalDateTime horarioCita = cita.getHorarioCita();

        // Obtener la lista de consultorios disponibles en el horario deseado
        List<Consultorio> consultoriosDisponibles = citaRepository.findAvailableConsultorios(horarioCita);

        if (consultoriosDisponibles.isEmpty()) {
            // No hay consultorios disponibles, manejar el caso según tus requerimientos
            return "redirect:/citas/agregar?error=NoConsultoriosDisponibles";
        }


        // Seleccionar un consultorio aleatorio de la lista de consultorios disponibles
        Random random = new Random();
        int randomIndex = random.nextInt(consultoriosDisponibles.size());
        Consultorio consultorioAsignado = consultoriosDisponibles.get(randomIndex);

        // Asignar el consultorio a la cita
        cita.setConsultorio(consultorioAsignado);

        // Guardar la cita en la base de datos
        citaRepository.save(cita);

        return "redirect:/citas";
    }

}
