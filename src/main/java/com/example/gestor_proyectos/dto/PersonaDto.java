package com.example.gestor_proyectos.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data

public class PersonaDto {

    private Integer id;
    @NotEmpty(message = "el campo nombre no puede estar vacío")
    @NotNull(message = "el campo nombre no puede ser nulo")
    private String nombres;
    private String apellidos;
    private String identificacion;
    private String genero;
    private String telefono;
    private String correo;
    private String usuario;
    private String contrasena;
    private List<RolDto> rol;
}
