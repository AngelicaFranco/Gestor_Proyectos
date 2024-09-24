package com.example.gestor_proyectos.repository;

import com.example.gestor_proyectos.entities.PersonaEntity;
import com.example.gestor_proyectos.entities.ProyectoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProyectoRepository extends JpaRepository<ProyectoEntity, Integer> {
    @Query(value = "select coalesce(sum(porcentaje_cumplimiento),0))\n"+
            "from proyecto"+
            "where id = :id", nativeQuery = true)
    Integer sumaPorcentajeTotal(@Param("id")Integer id);
}
