package com.luis.springboot.EduConnect.repositories;

import com.luis.springboot.EduConnect.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso,Long> {
}
