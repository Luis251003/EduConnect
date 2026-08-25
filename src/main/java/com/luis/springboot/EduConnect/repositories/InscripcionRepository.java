package com.luis.springboot.EduConnect.repositories;

import com.luis.springboot.EduConnect.models.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface InscripcionRepository extends JpaRepository<Inscripcion,Long> {

    @Query("SELECT i From Inscripcion i JOIN FETCH i.usuario JOIN FETCH i.curso WHERE i.curso.id = :cursoId")
    Optional<List<Inscripcion>> findByCursoIdWithDetails(@Param("cursoId") Long cursoId);
}
