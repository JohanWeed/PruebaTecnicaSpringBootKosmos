package com.hospital.hspoital_prueba.controller;

import com.hospital.hspoital_prueba.model.Doctor;
import com.hospital.hspoital_prueba.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorController {
    
    @Autowired
    private DoctorRepository doctorRepository;
    
    @RequestMapping("/doctors")
    @ResponseBody
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
    
}
