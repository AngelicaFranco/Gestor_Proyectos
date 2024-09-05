package com.example.gestor_proyectos.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "proyecto")

public class ProyectoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_proyecto")
    private String nombreProyecto;

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    private Date fechaFin;

    @Column(name = "descripcion_proyecto")
    private String descripcionProyecto;

    @Column(name = "porcentaje_cumplimiento")
    private Integer porcentajeCumplimiento;

    @Column(name = "estado_proyecto")
    private String estadoProyecto;
}
