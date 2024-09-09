package com.example.gestor_proyectos.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "id_proyecto")
    private ProyectoEntity proyecto;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "responsable_tarea",
            joinColumns = @JoinColumn(name = "id_persona", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_tarea", referencedColumnName = "id"))
    private List<TareaEntity> tareas;


}
