package com.luis.springboot.EduConnect.services;

import com.luis.springboot.EduConnect.DTOs.CursoRequestDTO;
import com.luis.springboot.EduConnect.DTOs.CursoResponseDTO;

import java.util.List;

public interface CursoService {

    //LISTAR CURSOS
    List<CursoResponseDTO> listarCursos();

    //CREAR NUEVO CURSO
    CursoResponseDTO guardarCurso(CursoRequestDTO bean);

}
