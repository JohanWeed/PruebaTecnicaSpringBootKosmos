package com.hospital.hspoital_prueba.controller;

//import com.hospital.hspoital_prueba.model.Cita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CitaController {
    
    @Autowired
    ///private Cita citaRepository;
    
    @RequestMapping("/citas")
    @ResponseBody
    public String getAllCitas() {
        return "Estas son mis citas";
    }
    
}
