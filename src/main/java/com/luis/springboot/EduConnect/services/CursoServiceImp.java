package com.luis.springboot.EduConnect.services;

import com.luis.springboot.EduConnect.DTOs.CursoRequestDTO;
import com.luis.springboot.EduConnect.DTOs.CursoResponseDTO;
import com.luis.springboot.EduConnect.repositories.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImp implements CursoService{

    //DECLARAMOS LA VARIABLE REPOSITORY
    private final CursoRepository cursoRepository;

    //DEFINIMOS LA VARIABLE REPOSITORY
    public CursoServiceImp(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    //LISTAR TODOS LOS CURSOS
    @Override
    public List<CursoResponseDTO> listarCursos() {
        return List.of();
    }

    //GUARDAR UN NUEVO CURSO
    @Override
    public CursoResponseDTO guardarCurso(CursoRequestDTO bean) {
        return null;
    }
}
