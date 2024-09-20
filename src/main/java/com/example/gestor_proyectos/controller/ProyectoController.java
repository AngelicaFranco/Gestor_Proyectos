package com.example.gestor_proyectos.controller;

import com.example.gestor_proyectos.dto.ProyectoDto;
import com.example.gestor_proyectos.services.ProyectoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("proyecto")

public class ProyectoController {

    @Autowired
    ProyectoService proyectoService;

    @PostMapping("/guardar")
    public ResponseEntity<String> guardar(@RequestBody @Valid ProyectoDto proyectoDto){
        return new ResponseEntity<>(proyectoService.guardarProyecto(proyectoDto), HttpStatus.CREATED);
    }
}
