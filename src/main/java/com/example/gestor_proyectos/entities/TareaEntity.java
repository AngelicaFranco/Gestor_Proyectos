package com.example.gestor_proyectos.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tarea")

public class TareaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "peso")
    private Integer peso;

    @Column(name = "porcentaje_cumplimiento")
    private Integer porcentajeCumplimiento;


}
