package com.example.gestor_proyectos.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class ProyectoDto {

    private Integer id;
    @NotEmpty(message = "el campo nombre del proyecto no puede estar vacío")
    @NotNull(message = "el campo nombre del proyecto no puede ser nulo")
    private String nombreProyecto;
    private Date fechaInicio;
    private Date fechaFin;
    @NotEmpty(message = "el campo descripcion no puede estar vacío")
    @NotNull(message = "el campo descripcion no puede ser nulo")
    private String descripcionProyecto;
    private Integer porcentajeCumplimiento;
    private String estadoProyecto;
    private PersonaDto responsable;
}
