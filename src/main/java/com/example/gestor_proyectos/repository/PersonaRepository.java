package com.example.gestor_proyectos.repository;

import com.example.gestor_proyectos.entities.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Integer> {

    PersonaEntity findByUsuario(String usuario);
}
