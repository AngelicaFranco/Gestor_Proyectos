package com.example.gestor_proyectos.services.impl;

import com.example.gestor_proyectos.dto.PersonaDto;
import com.example.gestor_proyectos.entities.PersonaEntity;
import com.example.gestor_proyectos.exceptions.ApiException;
import com.example.gestor_proyectos.repository.PersonaRepository;
import com.example.gestor_proyectos.services.PersonaService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j

public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    @Transactional
    public String guardarPersona(PersonaDto personaDto) {
        try {
            PersonaEntity personaEntityUsuario = personaRepository.findByUsuario(personaDto.getUsuario());
            if (personaEntityUsuario != null) {
                throw new ApiException("El usuario ya existe", HttpStatus.BAD_REQUEST);
            }
            PersonaEntity persona = mapper.map(personaDto, PersonaEntity.class);
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            persona.setContrasena(passwordEncoder.encode(persona.getContrasena()));
            personaRepository.save(persona);
            return "Persona guardada con éxito";

        } catch (Exception e) {
            if (e instanceof ApiException) {
                throw e;
            }
            log.error("Error al guardar la persona: {}", e.getMessage());
            throw new ApiException("Error al guardar la persona",HttpStatus.BAD_REQUEST);
        }

    }
}
