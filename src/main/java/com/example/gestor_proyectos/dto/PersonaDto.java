package com.example.gestor_proyectos.dto;

import lombok.Data;

import java.util.List;

@Data

public class PersonaDto {

    private Integer id;
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
