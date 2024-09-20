package com.example.gestor_proyectos.services.impl;

import com.example.gestor_proyectos.dto.ProyectoDto;
import com.example.gestor_proyectos.entities.ProyectoEntity;
import com.example.gestor_proyectos.exceptions.ApiException;
import com.example.gestor_proyectos.repository.ProyectoRepository;
import com.example.gestor_proyectos.services.ProyectoService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class ProyectoServiceImpl implements ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    @Transactional
    public String guardarProyecto(ProyectoDto proyectoDto) {

        Date fechaActual = new Date();
        try {

            if (fechaActual.after(proyectoDto.getFechaInicio())) {
                throw new ApiException("La fecha de inicio de proyecto no puede ser anterior a la fecha actual", HttpStatus.BAD_REQUEST);
            }
            if (proyectoDto.getFechaInicio().after(proyectoDto.getFechaFin())) {
                throw new ApiException("La fecha fin no puede ser anterior a la fecha de inicio del proyecto", HttpStatus.BAD_REQUEST);
            }

            ProyectoEntity proyecto = mapper.map(proyectoDto, ProyectoEntity.class);
            proyectoRepository.save(proyecto);
            return "Proyecto guardado con éxito";

        } catch (Exception e) {
            if (e instanceof ApiException) {
                throw e;
            }
            log.error("Error al guardar el proyecto: {}", e.getMessage());
            throw new ApiException("Error al guardar proyecto", HttpStatus.BAD_REQUEST);
        }


    }
}
