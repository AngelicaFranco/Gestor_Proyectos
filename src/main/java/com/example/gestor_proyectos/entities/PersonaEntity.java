package com.example.gestor_proyectos.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "persona")

public class PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "identificacion")
    private String identificacion;

    @Column(name = "genero")
    private String genero;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "correo")
    private String correo;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "contrasena")
    private String contrasena;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "persona_rol",joinColumns = @JoinColumn(name = "id_persona",
    referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "id_rol",
    referencedColumnName = "id"))
    private List<RolEntity> roles;

}
