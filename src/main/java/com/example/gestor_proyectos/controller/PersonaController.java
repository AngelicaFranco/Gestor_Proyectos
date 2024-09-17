package com.example.gestor_proyectos.controller;

import com.example.gestor_proyectos.dto.PersonaDto;
import com.example.gestor_proyectos.services.PersonaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persona")

public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping("/guardar")
    public ResponseEntity<String> guardar(@RequestBody @Valid PersonaDto personaDto) {
        return new ResponseEntity<>(personaService.guardarPersona(personaDto), HttpStatus.CREATED);
    }
}
