package com.example.gestor_proyectos.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "avances")

public class AvanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_avance")
    private String nombreAvance;

    @Column(name = "descripcion_avance")
    private String descripcionAvance;

    @Column(name = "fecha_ejecucion")
    private Date fechaEjecucion;

    @Column(name = "porcentaje_avance")
    private Integer porcentajeAvance;

    @ManyToOne
    @JoinColumn(name = "id_tarea")
    private TareaEntity tarea;
}
